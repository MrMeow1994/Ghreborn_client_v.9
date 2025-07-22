import java.math.BigInteger;
import sign.signlink;

public final class Stream extends Class30_Sub2 {
    public ISAACRandomGen encryption;
    private static int anInt1411;
    private static int anInt1412;
    private static int anInt1413;
    public static boolean aBoolean1418;
    public byte[] buffer;
    public int currentPosition;
    private int anInt1389;
    private int anInt1390;
    private byte aByte1391;
    private int anInt1392;
    private int anInt1393;
    private byte aByte1394;
    private int anInt1395;
    private boolean aBoolean1396;
    private int anInt1397;
    private byte aByte1398;
    private byte aByte1399;
    private byte aByte1400;
    private boolean aBoolean1401;
    private int anInt1402;
    private boolean aBoolean1403;
    private boolean aBoolean1404;
    public int anInt1407;
    private static final BigInteger RSA_MODULUS = new BigInteger("129054814732918521522820496413796482564146106440479997463524816763080780831995631078504790292317658383472514719172206718041945316394359609923527595131308647792229034016245090408424074669977492602693984712211573066192823392981891207916047022843940335910271752018248983400185186778063159281890985050648461506327");
    private static final BigInteger RSA_EXPONENT = new BigInteger("65537");
    private static final int[] anIntArray1409 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    private static DoubleEndedQueue aDoubleEndedQueue_1414 = new DoubleEndedQueue(169);
    private static DoubleEndedQueue aDoubleEndedQueue_1415 = new DoubleEndedQueue(169);
    private static DoubleEndedQueue aDoubleEndedQueue_1416 = new DoubleEndedQueue(169);
    private static char[] aCharArray1417 = new char[]{'\u0041', '\u0042', '\u0043', '\u0044', '\u0045', '\u0046', '\u0047', '\u0048', '\u0049', '\u004a', '\u004b', '\u004c', '\u004d', '\u004e', '\u004f', '\u0050', '\u0051', '\u0052', '\u0053', '\u0054', '\u0055', '\u0056', '\u0057', '\u0058', '\u0059', '\u005a', '\u0061', '\u0062', '\u0063', '\u0064', '\u0065', '\u0066', '\u0067', '\u0068', '\u0069', '\u006a', '\u006b', '\u006c', '\u006d', '\u006e', '\u006f', '\u0070', '\u0071', '\u0072', '\u0073', '\u0074', '\u0075', '\u0076', '\u0077', '\u0078', '\u0079', '\u007a', '\u0030', '\u0031', '\u0032', '\u0033', '\u0034', '\u0035', '\u0036', '\u0037', '\u0038', '\u0039', '\u002b', '\u002f'};
    private static int[] anIntArray1408 = new int[256];

    public Stream(byte[] abyte0) {
        this.buffer = abyte0;
        this.currentPosition = 0;
    }

    final int v(int i) {
        this.currentPosition += 3;
        return (255 & this.buffer[this.currentPosition - 3] << 16) + (255 & this.buffer[this.currentPosition - 2] << 8) + (255 & this.buffer[this.currentPosition - 1]);
    }

    public static Stream method396(int i, int j) {
        Stream stream_1 = new Stream(false);
        stream_1.currentPosition = 0;
        if(i == 0) {
            stream_1.buffer = new byte[100];
        } else if(i == 1) {
            stream_1.buffer = new byte['\u9c40'];
        } else {
            stream_1.buffer = new byte[30000];
        }

        return stream_1;
    }

    private Stream(boolean flag) {
        this.anInt1389 = 891;
        this.anInt1390 = 9;
        this.aByte1391 = 14;
        this.anInt1392 = -29508;
        this.anInt1393 = 881;
        this.aByte1394 = 8;
        this.anInt1395 = 657;
        this.aBoolean1396 = false;
        this.anInt1397 = -715;
        this.aByte1398 = -57;
        this.aByte1399 = 108;
        this.aByte1400 = 3;
        this.aBoolean1401 = false;
        this.anInt1402 = -373;
        this.aBoolean1403 = false;
        this.aBoolean1404 = true;
        if(flag) {
            throw new NullPointerException();
        }
    }

    public Stream(byte[] abyte0, int i) {
        this.anInt1389 = 891;
        this.anInt1390 = 9;
        this.aByte1391 = 14;
        this.anInt1392 = -29508;
        this.anInt1393 = 881;
        this.aByte1394 = 8;
        this.anInt1395 = 657;
        this.aBoolean1396 = false;
        this.anInt1397 = -715;
        this.aByte1398 = -57;
        this.aByte1399 = 108;
        this.aByte1400 = 3;
        this.aBoolean1401 = false;
        this.anInt1402 = -373;
        this.aBoolean1403 = false;
        this.aBoolean1404 = true;
        if(i <= 0) {
            throw new NullPointerException();
        } else {
            this.buffer = abyte0;
            this.currentPosition = 0;
        }
    }

    public void createFrame(int i) {
        this.buffer[this.currentPosition++] = (byte)(i + this.encryption.getNextIntKey());
    }

    public void writeUnsignedByte(int i) {
        this.buffer[this.currentPosition++] = (byte)i;
    }

    public void writeWord(int i) {
        this.buffer[this.currentPosition++] = (byte)(i >> 8);
        this.buffer[this.currentPosition++] = (byte)i;
    }

    public void method400(boolean flag, int i) {
        this.buffer[this.currentPosition++] = (byte)i;
        this.buffer[this.currentPosition++] = (byte)(i >> 8);
        if(!flag) {
            this.anInt1389 = -142;
        }

    }

    public void method401(int i) {
        this.buffer[this.currentPosition++] = (byte)(i >> 16);
        this.buffer[this.currentPosition++] = (byte)(i >> 8);
        this.buffer[this.currentPosition++] = (byte)i;
    }

    public void writeDWord(int i) {
        this.buffer[this.currentPosition++] = (byte)(i >> 24);
        this.buffer[this.currentPosition++] = (byte)(i >> 16);
        this.buffer[this.currentPosition++] = (byte)(i >> 8);
        this.buffer[this.currentPosition++] = (byte)i;
    }

    public void method403(int i, int j) {
        this.buffer[this.currentPosition++] = (byte)j;
        this.buffer[this.currentPosition++] = (byte)(j >> 8);
        if(i == 0) {
            this.buffer[this.currentPosition++] = (byte)(j >> 16);
            this.buffer[this.currentPosition++] = (byte)(j >> 24);
        }
    }

    public int readShort2() {
        this.currentPosition += 2;
        int i = ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] & 255);
        if(i > 32767) {
            i -= 65537;
        }

        return i;
    }

    public void method404(int i, long l) {
        try {
            this.buffer[this.currentPosition++] = (byte)((int)(l >> 56));
            this.buffer[this.currentPosition++] = (byte)((int)(l >> 48));
            this.buffer[this.currentPosition++] = (byte)((int)(l >> 40));
            this.buffer[this.currentPosition++] = (byte)((int)(l >> 32));
            if(i < 5 || i > 5) {
                this.anInt1402 = 409;
            }

            this.buffer[this.currentPosition++] = (byte)((int)(l >> 24));
            this.buffer[this.currentPosition++] = (byte)((int)(l >> 16));
            this.buffer[this.currentPosition++] = (byte)((int)(l >> 8));
            this.buffer[this.currentPosition++] = (byte)((int)l);
        } catch (RuntimeException var5) {
            signlink.reporterror("14395, " + i + ", " + l + ", " + var5.toString());
            throw new RuntimeException();
        }
    }

    public String readNewString() {
        int i = this.currentPosition;

        while(this.buffer[this.currentPosition++] != 0) {
            ;
        }

        return new String(this.buffer, i, this.currentPosition - i - 1);
    }

    public void writeString(String s) {
        s.getBytes(0, s.length(), this.buffer, this.currentPosition);
        this.currentPosition += s.length();
        this.buffer[this.currentPosition++] = 10;
    }

    public int getShort() {
        this.currentPosition += 2;
        return ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] & 255);
    }

    public int getTribyte() {
        this.currentPosition += 3;
        return ((this.buffer[this.currentPosition - 3] & 255) << 16) + ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] & 255);
    }

    public void writeBytes(byte[] abyte0, int i, boolean flag, int j) {
        if(!flag) {
            this.aBoolean1401 = !this.aBoolean1401;
        }

        for(int k = j; k < j + i; ++k) {
            this.buffer[this.currentPosition++] = abyte0[k];
        }

    }

    public void method407(int i, byte byte0) {
        this.buffer[this.currentPosition - i - 1] = (byte)i;
        if(byte0 == 0) {
            boolean byte01 = false;
        }

    }

    public int readUnsignedByte() {
        return this.buffer[this.currentPosition++] & 255;
    }

    public byte readSignedByte() {
        return this.buffer[this.currentPosition++];
    }

    public int readUnsignedShort() {
        this.currentPosition += 2;
        return ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] & 255);
    }

    public int readSignedWord() {
        this.currentPosition += 2;
        int i = ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] & 255);
        if(i > 32767) {
            i -= 65536;
        }

        return i;
    }

    public int method912(int i) {
        ++this.currentPosition;
        int i_6_ = this.buffer[this.currentPosition] & i;
        return i_6_ < 128?this.readUnsignedByte():-32768 + this.readUnsignedShort();
    }

    public int method1606() {
        int var2 = 0;

        int var3;
        for(var3 = this.readUShortSmart(); var3 == 32767; var3 = this.readUShortSmart()) {
            var2 += 32767;
        }

        var2 += var3;
        return var2;
    }

    public int readUShortSmart() {
        int var2 = this.buffer[this.currentPosition] & 255;
        return var2 < 128?this.readUnsignedByte():this.readUnsignedShort() - '\u8000';
    }
    public int method802(int arg0) {
        int i = 0;
        try {
            currentPosition++;
            int i_17_ = 121 / ((arg0 - -28) / 41);
            int i_18_ = 0;
            int i_19_ = method818((byte) 66);
            while (i_19_ == 32767) {
                i_19_ = method818((byte) 61);
                i_18_ += 32767;
            }
            i_18_ += i_19_;
            i = i_18_;
        } catch (RuntimeException runtimeexception) {

        }
        return i;
    }
    public int method818(byte arg0) {
        try {
            while_574_:
            do {
                do {
                    int i;
                    try {
                        int i_22_ = 1 % ((arg0 - -28) / 54);
                        currentPosition++;
                        int i_23_ = 0xff & buffer[currentPosition];
                        if (i_23_ >= 128)
                            break;
                        i = readUnsignedByte();
                    } catch (RuntimeException runtimeexception) {
                        break while_574_;
                    }
                    return i;
                } while (false);
                int i;
                try {
                    i = method784((byte) 114) + -32768;
                } catch (RuntimeException runtimeexception) {
                    break;
                }
                return i;
            } while (false);
        } catch (RuntimeException runtimeexception) {

        }
        return -1;
    }
    public int method784(byte arg0) {
        int i = 0;
        try {
            currentPosition += 2;
            currentPosition++;
            i = ((0xff & buffer[currentPosition + -1])
                    + (0xff00 & buffer[currentPosition - 2] << 8));
        } catch (RuntimeException runtimeexception) {
        }
        return i;
    }
    public int method802() {
        int i = 0;
        try {
            currentPosition++;
            int i_18_ = 0;
            int i_19_ = method818((byte) 66);
            while (i_19_ == 32767) {
                i_19_ = method818((byte) 61);
                i_18_ += 32767;
            }
            i_18_ += i_19_;
            i = i_18_;
        } catch (RuntimeException runtimeexception) {
        }
        return i;
    }
    public int method937(boolean bool) {
        ++this.currentPosition;
        int i = 0;
        int i_25_ = this.method912(255);
        if(!bool) {
            return -6;
        } else {
            while(i_25_ == 32767) {
                i += 32767;
                i_25_ = this.method912(255);
            }

            i += i_25_;
            return i;
        }
    }

    public int method1758(int arg0) {
        ++this.currentPosition;
        int i = 0;
        int i_33_ = this.readSmart(arg0 ^ -1647911569);
        if(arg0 != 32767) {
            this.method1717(-82, 97);
        }

        while(~i_33_ == -32768) {
            i_33_ = this.readSmart(-1647926640);
            i += 32767;
        }

        i += i_33_;
        return i;
    }

    public long method1717(int arg0, int arg1) {
        ++this.currentPosition;
        --arg0;
        if(arg1 <= arg0 && arg0 <= 7) {
            int i = 8 * arg0;

            long l;
            for(l = 0L; i >= 0; i -= 8) {
                l |= ((long)this.buffer[this.currentPosition++] & 255L) << i;
            }

            return l;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int read3Bytes() {
        this.currentPosition += 3;
        return ((this.buffer[this.currentPosition - 3] & 255) << 16) + ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] & 255);
    }

    public int readDWord() {
        this.currentPosition += 4;
        return ((this.buffer[this.currentPosition - 4] & 255) << 24) + ((this.buffer[this.currentPosition - 3] & 255) << 16) + ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] & 255);
    }

    public long readQWord(int i) {
        long l = (long)this.readDWord() & 4294967295L;
        if(i != -35089) {
            this.aBoolean1403 = !this.aBoolean1403;
        }

        long l1 = (long)this.readDWord() & 4294967295L;
        return (l << 32) + l1;
    }

    public String readString() {
        int i = this.currentPosition;

        while(this.buffer[this.currentPosition++] != 10) {
            ;
        }

        return new String(this.buffer, i, this.currentPosition - i - 1);
    }

    public byte[] method416(byte byte0) {
        int i = this.currentPosition;

        while(this.buffer[this.currentPosition++] != 10) {
            ;
        }

        byte[] abyte0 = new byte[this.currentPosition - i - 1];
        if(byte0 != 30) {
            this.aBoolean1404 = !this.aBoolean1404;
        }

        for(int j = i; j < this.currentPosition - 1; ++j) {
            abyte0[j - i] = this.buffer[j];
        }

        return abyte0;
    }

    public void method417(int i, byte byte0, int j, byte[] abyte0) {
        int l;
        if(byte0 != 14) {
            for(l = 1; l > 0; ++l) {
                ;
            }
        }

        for(l = j; l < j + i; ++l) {
            abyte0[l] = this.buffer[this.currentPosition++];
        }

    }

    public void initBitAccess(int i) {
        this.anInt1407 = this.currentPosition * 8;
        if(i != this.anInt1392) {
            for(int j = 1; j > 0; ++j) {
                ;
            }
        }

    }

    public int readBits(int i) {
        int k = this.anInt1407 >> 3;
        int l = 8 - (this.anInt1407 & 7);
        int i1 = 0;

        for(this.anInt1407 += i; i > l; l = 8) {
            i1 += (this.buffer[k++] & anIntArray1409[l]) << i - l;
            i -= l;
        }

        if(i == l) {
            i1 += this.buffer[k] & anIntArray1409[l];
        } else {
            i1 += this.buffer[k] >> l - i & anIntArray1409[i];
        }

        return i1;
    }

    public void method420(boolean flag) {
        this.currentPosition = (this.anInt1407 + 7) / 8;
        if(!flag) {
            for(int i = 1; i > 0; ++i) {
                ;
            }
        }

    }

    public int method421() {
        int i = this.buffer[this.currentPosition] & 255;
        return i < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '\uc000';
    }

    public int readUSmart() {
        int peek = this.buffer[this.currentPosition] & 255;
        return peek < 128?this.readUnsignedByte():this.readUnsignedShort() - '\u8000';
    }

    public int readUSmart2() {
        int baseVal = 0;

        int lastVal1;
        for(boolean lastVal = false; (lastVal1 = this.readUSmart()) == 32767; baseVal += 32767) {
            ;
        }

        return baseVal + lastVal1;
    }

    public int readSmart() {
        int value = this.buffer[this.currentPosition] & 255;
        return value < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '\uc000';
    }

    public int readSmart(int arg0) {
        ++this.currentPosition;
        if(arg0 != -1647926640) {
            return 81;
        } else {
            int i = 255 & this.buffer[this.currentPosition];
            return i >= 128?-32768 + this.readUnsignedShort():this.readUnsignedByte();
        }
    }

    public void doKeys(BigInteger biginteger, BigInteger biginteger1, byte byte0) {
        int i = this.currentPosition;
        this.currentPosition = 0;
        byte[] abyte0 = new byte[i];
        this.method417(i, this.aByte1391, 0, abyte0);
        BigInteger biginteger2 = new BigInteger(abyte0);
        if(byte0 != 0) {
            this.aBoolean1403 = !this.aBoolean1403;
        }

        BigInteger biginteger3 = biginteger2.modPow(RSA_EXPONENT, RSA_MODULUS);
        byte[] abyte1 = biginteger3.toByteArray();
        this.currentPosition = 0;
        this.writeUnsignedByte(abyte1.length);
        this.writeBytes(abyte1, abyte1.length, true, 0);
    }

    public void method424(int i, int j) {
        this.buffer[this.currentPosition++] = (byte)(-i);
        if(j != 0) {
            for(int k = 1; k > 0; ++k) {
                ;
            }
        }

    }

    public void method425(int i, int j) {
        this.buffer[this.currentPosition++] = (byte)(128 - j);
        i = 90 / i;
    }

    public int readByteS(int i) {
        return i != 0?this.anInt1395:this.buffer[this.currentPosition++] - 128 & 255;
    }

    public int readByteC(boolean flag) {
        if(flag) {
            this.anInt1389 = 310;
        }

        return -this.buffer[this.currentPosition++] & 255;
    }

    public int readByteA(int i) {
        if(i != 2) {
            this.aBoolean1404 = !this.aBoolean1404;
        }

        return 128 - this.buffer[this.currentPosition++] & 255;
    }

    public byte method429(byte byte0) {
        if(byte0 != this.aByte1398) {
            throw new NullPointerException();
        } else {
            return (byte)(-this.buffer[this.currentPosition++]);
        }
    }

    public byte method430(int i) {
        if(i != 0) {
            for(int j = 1; j > 0; ++j) {
                ;
            }
        }

        return (byte)(128 - this.buffer[this.currentPosition++]);
    }

    public void method431(boolean flag, int i) {
        this.buffer[this.currentPosition++] = (byte)i;
        this.buffer[this.currentPosition++] = (byte)(i >> 8);
        if(!flag) {
            this.aBoolean1401 = !this.aBoolean1401;
        }

    }

    public void method432(int i, int j) {
        for(this.buffer[this.currentPosition++] = (byte)(j >> 8); i >= 0; this.anInt1402 = 376) {
            ;
        }

        this.buffer[this.currentPosition++] = (byte)(j + 128);
    }

    public void method433(int i, int j) {
        this.buffer[this.currentPosition++] = (byte)(j + 128);
        if(i != 0) {
            this.anInt1402 = -238;
        }

        this.buffer[this.currentPosition++] = (byte)(j >> 8);
    }

    public int method434(byte byte0) {
        this.currentPosition += 2;
        return byte0 != this.aByte1399?3:((this.buffer[this.currentPosition - 1] & 255) << 8) + (this.buffer[this.currentPosition - 2] & 255);
    }

    public int readUShortA(boolean flag) {
        if(!flag) {
            for(int i = 1; i > 0; ++i) {
                ;
            }
        }

        this.currentPosition += 2;
        return ((this.buffer[this.currentPosition - 2] & 255) << 8) + (this.buffer[this.currentPosition - 1] - 128 & 255);
    }

    public int method436(byte byte0) {
        this.currentPosition += 2;
        if(byte0 != -74) {
            for(int i = 1; i > 0; ++i) {
                ;
            }
        }

        return ((this.buffer[this.currentPosition - 1] & 255) << 8) + (this.buffer[this.currentPosition - 2] - 128 & 255);
    }

    public int method437(int i) {
        this.currentPosition += 2;
        if(i >= 0) {
            return 2;
        } else {
            int j = ((this.buffer[this.currentPosition - 1] & 255) << 8) + (this.buffer[this.currentPosition - 2] & 255);
            if(j > 32767) {
                j -= 65536;
            }

            return j;
        }
    }
    public int readUnsignedWordA() {
        currentPosition += 2;
        return ((buffer[currentPosition - 2] & 0xff) << 8) + (buffer[currentPosition - 1] - 128 & 0xff);
    }
    public int method438(boolean flag) {
        int j;
        if(flag) {
            for(j = 1; j > 0; ++j) {
                ;
            }
        }

        this.currentPosition += 2;
        j = ((this.buffer[this.currentPosition - 1] & 255) << 8) + (this.buffer[this.currentPosition - 2] - 128 & 255);
        if(j > 32767) {
            j -= 65536;
        }

        return j;
    }

    public int method439(byte byte0) {
        if(byte0 != 41) {
            return 3;
        } else {
            this.currentPosition += 4;
            return ((this.buffer[this.currentPosition - 2] & 255) << 24) + ((this.buffer[this.currentPosition - 1] & 255) << 16) + ((this.buffer[this.currentPosition - 4] & 255) << 8) + (this.buffer[this.currentPosition - 3] & 255);
        }
    }

    public int method440(boolean flag) {
        if(!flag) {
            this.aBoolean1396 = !this.aBoolean1396;
        }

        this.currentPosition += 4;
        return ((this.buffer[this.currentPosition - 3] & 255) << 24) + ((this.buffer[this.currentPosition - 4] & 255) << 16) + ((this.buffer[this.currentPosition - 1] & 255) << 8) + (this.buffer[this.currentPosition - 2] & 255);
    }

    public void method441(int i, byte byte0, byte[] abyte0, int j) {
        if(byte0 != 6) {
            this.aBoolean1396 = !this.aBoolean1396;
        }

        for(int k = i + j - 1; k >= i; --k) {
            this.buffer[this.currentPosition++] = (byte)(abyte0[k] + 128);
        }

    }

    public void method442(int i, int j, boolean flag, byte[] abyte0) {
        if(!flag) {
            this.aBoolean1396 = !this.aBoolean1396;
        }

        for(int k = j + i - 1; k >= j; --k) {
            abyte0[k] = this.buffer[this.currentPosition++];
        }

    }

    static {
        for(int j = 0; j < 256; ++j) {
            int i = j;

            for(int k = 0; k < 8; ++k) {
                if((i & 1) == 1) {
                    i = i >>> 1 ^ -306674912;
                } else {
                    i >>>= 1;
                }
            }

            anIntArray1408[j] = i;
        }

    }
}
