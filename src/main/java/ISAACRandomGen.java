public final class ISAACRandomGen {

    private static final int[] SIZES = {
            64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768
    };

    private static final int GOLDEN_RATIO = 0x9e3779b9;

    private final long[][] results = new long[10][];
    private final long[][] memory = new long[10][];

    private final long[] a = new long[10];
    private final long[] b = new long[10];
    private final long[] c = new long[10];

    private final int[] indices = new int[10];

    public ISAACRandomGen(int[] seed) {
        for (int layer = 0; layer < 10; layer++) {
            int size = SIZES[layer];
            results[layer] = new long[size];
            memory[layer] = new long[size];
            long[] expandedSeed = expandSeed(seed, size);
            System.arraycopy(expandedSeed, 0, results[layer], 0, size);
            initializeState(memory[layer], results[layer], size, (layer % 3 == 0) ? this::mix1 : (layer % 3 == 1) ? this::mix2 : this::mix3);
            isaac(memory[layer], results[layer], size, size - 1, true, layer);
            indices[layer] = size;
        }
    }
    public int getNextIntKey() {
        long key = getNextKey();
        return (int)(key ^ (key >>> 32)); // XOR fold into 32 bits
    }
    public long getNextKey() {
        long output = 0;
        for (int layer = 0; layer < 10; layer++) {
            int size = SIZES[layer];
            int mask = size - 1;

            if (--indices[layer] < 0) {
                isaac(memory[layer], results[layer], size, mask, false, layer);
                indices[layer] = size - 1;
            }

            output ^= Long.rotateRight(results[layer][indices[layer]], layer + 1);
        }
        return output;
    }

    public long getNextKey(long salt) {
        for (int i = 0; i < 10; i++) {
            c[i] ^= salt >>> (i % 32);
        }
        return getNextKey();
    }

    private void isaac(long[] memory, long[] results, int size, int mask, boolean init, int layer) {
        if (init) b[layer] += ++c[layer];

        long aVal = a[layer], bVal = b[layer], cVal = c[layer];

        for (int i = 0; i < size; i++) {
            long x = memory[i];
            switch (i & 3) {
                case 0: aVal ^= aVal << 21; break;
                case 1: aVal ^= aVal >>> 7; break;
                case 2: aVal ^= aVal << 3; break;
                case 3: aVal ^= aVal >>> 13; break;
            }
            aVal += memory[(i + (size / 2)) & mask];
            long y = memory[i] = memory[(int)(x >>> 2) & mask] + aVal + bVal;
            results[i] = bVal = memory[(int)(y >>> 10) & mask] + x;
        }

        a[layer] = aVal; b[layer] = bVal;
    }

    private void initializeState(long[] memory, long[] results, int size, MixFunction mixer) {
        long a = GOLDEN_RATIO, b = GOLDEN_RATIO, c = GOLDEN_RATIO, d = GOLDEN_RATIO;
        long e = GOLDEN_RATIO, f = GOLDEN_RATIO, g = GOLDEN_RATIO, h = GOLDEN_RATIO;

        for (int i = 0; i < 4; i++) {
            a ^= b << 11; d += a; b += c;
            b ^= c >>> 2; e += b; c += d;
            c ^= d << 8; f += c; d += e;
            d ^= e >>> 16; g += d; e += f;
            e ^= f << 10; h += e; f += g;
            f ^= g >>> 4; a += f; g += h;
            g ^= h << 8; b += g; h += a;
            h ^= a >>> 9; c += h; a += b;
        }

        for (int i = 0; i < size; i += 8) {
            a += results[i];     b += results[i + 1];
            c += results[i + 2]; d += results[i + 3];
            e += results[i + 4]; f += results[i + 5];
            g += results[i + 6]; h += results[i + 7];
            mixer.mix(memory, i, a, b, c, d, e, f, g, h);
        }

        for (int i = 0; i < size; i += 8) {
            a += memory[i];     b += memory[i + 1];
            c += memory[i + 2]; d += memory[i + 3];
            e += memory[i + 4]; f += memory[i + 5];
            g += memory[i + 6]; h += memory[i + 7];
            mixer.mix(memory, i, a, b, c, d, e, f, g, h);
        }
    }

    private void mix1(long[] memory, int i, long a, long b, long c, long d, long e, long f, long g, long h) {
        a ^= b << 11; d += a; b += c;
        b ^= c >>> 2; e += b; c += d;
        c ^= d << 8; f += c; d += e;
        d ^= e >>> 16; g += d; e += f;
        e ^= f << 10; h += e; f += g;
        f ^= g >>> 4; a += f; g += h;
        g ^= h << 8; b += g; h += a;
        h ^= a >>> 9; c += h; a += b;
        for (int j = 0; j < 8; j++) memory[i + j] = new long[]{a, b, c, d, e, f, g, h}[j];
    }

    private void mix2(long[] memory, int i, long a, long b, long c, long d, long e, long f, long g, long h) {
        a ^= c << 10; d += b; c += e;
        b ^= e >>> 3; f += a; e += g;
        c ^= g << 5; g += h; f += b;
        d ^= a >>> 7; h += c; g += d;
        e ^= b << 12; a += e; h += f;
        f ^= c >>> 6; b += f; a += g;
        g ^= d << 9; c += g; b += h;
        h ^= e >>> 11; d += h; c += a;
        for (int j = 0; j < 8; j++) memory[i + j] = new long[]{a, b, c, d, e, f, g, h}[j];
    }

    private void mix3(long[] memory, int i, long a, long b, long c, long d, long e, long f, long g, long h) {
        a += f ^ (h >>> 3); b += g ^ (a << 7);
        c ^= b << 11; d ^= c >>> 5;
        e += d ^ (f << 3); f += e ^ (g >>> 13);
        g ^= a << 9; h ^= g >>> 6;
        for (int j = 0; j < 8; j++) memory[i + j] = new long[]{a, b, c, d, e, f, g, h}[j];
    }

    private long[] expandSeed(int[] seed, int size) {
        long[] result = new long[size];
        for (int i = 0; i < size; i++) {
            result[i] = seed[i % seed.length];
        }
        return result;
    }

    @FunctionalInterface
    private interface MixFunction {
        void mix(long[] memory, int i, long a, long b, long c, long d, long e, long f, long g, long h);
    }
}
