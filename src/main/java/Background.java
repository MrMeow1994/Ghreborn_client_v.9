public final class Background extends DrawingArea
{

    public Background(FileArchive fileArchive, String s, int i)
    {
        aBoolean1447 = false;
        anInt1448 = 360;
        aByte1449 = 3;
        Stream stream = new Stream(fileArchive.method571(s + ".dat"), 891);
        Stream stream_1 = new Stream(fileArchive.method571("index.dat"), 891);
        stream_1.currentPosition = stream.readUnsignedShort();
        anInt1456 = stream_1.readUnsignedShort();
        anInt1457 = stream_1.readUnsignedShort();
        int j = stream_1.readUnsignedByte();
        anIntArray1451 = new int[j];
        for(int k = 0; k < j - 1; k++)
            anIntArray1451[k + 1] = stream_1.read3Bytes();

        for(int l = 0; l < i; l++)
        {
            stream_1.currentPosition += 2;
            stream.currentPosition += stream_1.readUnsignedShort() * stream_1.readUnsignedShort();
            stream_1.currentPosition++;
        }

        anInt1454 = stream_1.readUnsignedByte();
        anInt1455 = stream_1.readUnsignedByte();
        anInt1452 = stream_1.readUnsignedShort();
        anInt1453 = stream_1.readUnsignedShort();
        int i1 = stream_1.readUnsignedByte();
        int j1 = anInt1452 * anInt1453;
        aByteArray1450 = new byte[j1];
        if(i1 == 0)
        {
            for(int k1 = 0; k1 < j1; k1++)
                aByteArray1450[k1] = stream.readSignedByte();

            return;
        }
        if(i1 == 1)
        {
            for(int l1 = 0; l1 < anInt1452; l1++)
            {
                for(int i2 = 0; i2 < anInt1453; i2++)
                    aByteArray1450[l1 + i2 * anInt1452] = stream.readSignedByte();

            }

        }
    }

    public void method356(boolean flag)
    {
        anInt1456 /= 2;
        anInt1457 /= 2;
        byte abyte0[] = new byte[anInt1456 * anInt1457];
        int i = 0;
        for(int j = 0; j < anInt1453; j++)
        {
            for(int k = 0; k < anInt1452; k++)
                abyte0[(k + anInt1454 >> 1) + (j + anInt1455 >> 1) * anInt1456] = aByteArray1450[i++];

        }

        aByteArray1450 = abyte0;
        anInt1452 = anInt1456;
        anInt1453 = anInt1457;
        anInt1454 = 0;
        if(flag)
        {
            return;
        } else
        {
            anInt1455 = 0;
            return;
        }
    }

    public void method357(boolean flag)
    {
        if(anInt1452 == anInt1456 && anInt1453 == anInt1457)
            return;
        byte abyte0[] = new byte[anInt1456 * anInt1457];
        if(flag)
            return;
        int i = 0;
        for(int j = 0; j < anInt1453; j++)
        {
            for(int k = 0; k < anInt1452; k++)
                abyte0[k + anInt1454 + (j + anInt1455) * anInt1456] = aByteArray1450[i++];

        }

        aByteArray1450 = abyte0;
        anInt1452 = anInt1456;
        anInt1453 = anInt1457;
        anInt1454 = 0;
        anInt1455 = 0;
    }

    public void method358(int i)
    {
        if(i != 0)
            return;
        byte abyte0[] = new byte[anInt1452 * anInt1453];
        int j = 0;
        for(int k = 0; k < anInt1453; k++)
        {
            for(int l = anInt1452 - 1; l >= 0; l--)
                abyte0[j++] = aByteArray1450[l + k * anInt1452];

        }

        aByteArray1450 = abyte0;
        anInt1454 = anInt1456 - anInt1452 - anInt1454;
    }

    public void method359(boolean flag)
    {
        byte abyte0[] = new byte[anInt1452 * anInt1453];
        int i = 0;
        for(int j = anInt1453 - 1; j >= 0; j--)
        {
            for(int k = 0; k < anInt1452; k++)
                abyte0[i++] = aByteArray1450[k + j * anInt1452];

        }

        aByteArray1450 = abyte0;
        if(!flag)
            anInt1446 = -48;
        anInt1455 = anInt1457 - anInt1453 - anInt1455;
    }

    public void method360(int i, int j, int k, int l)
    {
        for(int i1 = 0; i1 < anIntArray1451.length; i1++)
        {
            int j1 = anIntArray1451[i1] >> 16 & 0xff;
            j1 += i;
            if(j1 < 0)
                j1 = 0;
            else
            if(j1 > 255)
                j1 = 255;
            int k1 = anIntArray1451[i1] >> 8 & 0xff;
            k1 += j;
            if(k1 < 0)
                k1 = 0;
            else
            if(k1 > 255)
                k1 = 255;
            int l1 = anIntArray1451[i1] & 0xff;
            l1 += k;
            if(l1 < 0)
                l1 = 0;
            else
            if(l1 > 255)
                l1 = 255;
            anIntArray1451[i1] = (j1 << 16) + (k1 << 8) + l1;
        }

        if(l != 0)
            anInt1446 = 69;
    }

    public void method361(int i, int k)
    {
        i += anInt1454;
        k += anInt1455;
        int l = i + k * DrawingArea.width;
        int i1 = 0;
        int j1 = anInt1453;
        int k1 = anInt1452;
        int l1 = DrawingArea.width - k1;
        int i2 = 0;
        if(k < DrawingArea.topY)
        {
            int j2 = DrawingArea.topY - k;
            j1 -= j2;
            k = DrawingArea.topY;
            i1 += j2 * k1;
            l += j2 * DrawingArea.width;
        }
        if(k + j1 > DrawingArea.bottomY)
            j1 -= (k + j1) - DrawingArea.bottomY;
        if(i < DrawingArea.leftX)
        {
            int k2 = DrawingArea.leftX - i;
            k1 -= k2;
            i = DrawingArea.leftX;
            i1 += k2;
            l += k2;
            i2 += k2;
            l1 += k2;
        }
        if(i + k1 > DrawingArea.bottomX)
        {
            int l2 = (i + k1) - DrawingArea.bottomX;
            k1 -= l2;
            i2 += l2;
            l1 += l2;
        }
        if(k1 <= 0 || j1 <= 0)
        {
            return;
        } else
        {
            method362(j1, (byte)9, DrawingArea.pixels, aByteArray1450, l1, l, k1, i1, anIntArray1451, i2);
            return;
        }
    }

    private void method362(int i, byte byte0, int ai[], byte abyte0[], int j, int k, int l, 
            int i1, int ai1[], int j1)
    {
        if(byte0 != 9)
            aBoolean1447 = !aBoolean1447;
        int k1 = -(l >> 2);
        l = -(l & 3);
        for(int l1 = -i; l1 < 0; l1++)
        {
            for(int i2 = k1; i2 < 0; i2++)
            {
                byte byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
                byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
                byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
                byte1 = abyte0[i1++];
                if(byte1 != 0)
                    ai[k++] = ai1[byte1 & 0xff];
                else
                    k++;
            }

            for(int j2 = l; j2 < 0; j2++)
            {
                byte byte2 = abyte0[i1++];
                if(byte2 != 0)
                    ai[k++] = ai1[byte2 & 0xff];
                else
                    k++;
            }

            k += j;
            i1 += j1;
        }

    }

    private int anInt1446;
    private boolean aBoolean1447;
    private int anInt1448;
    private byte aByte1449;
    public byte aByteArray1450[];
    public int anIntArray1451[];
    public int anInt1452;
    public int anInt1453;
    public int anInt1454;
    public int anInt1455;
    public int anInt1456;
    public int anInt1457;
}
