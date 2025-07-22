// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public final class FileArchive
{

    public FileArchive(byte abyte0[])
    {
        aByte723 = 0;
        anInt724 = 9;
        anInt725 = -29508;

            a(abyte0);
    }

    private void a(byte abyte0[])
    {
        Stream stream = new Stream(abyte0, 891);
        int i = stream.read3Bytes();
        int j = stream.read3Bytes();
        if(j != i) {
            byte abyte1[] = new byte[i];
            BZip2Decompressor.getStreamAvailableOut(abyte1, i, abyte0, j, 6);
            aByteArray726 = abyte1;
            stream = new Stream(aByteArray726, 891);
            aBoolean732 = true;
        } else {
            aByteArray726 = abyte0;
            aBoolean732 = false;
        }
        dataSize = stream.readUnsignedShort();
        archiveNameHash = new int[dataSize];
        anIntArray729 = new int[dataSize];
        anIntArray730 = new int[dataSize];
        anIntArray731 = new int[dataSize];
        int k = stream.currentPosition + dataSize * 10;
        for(int l = 0; l < dataSize; l++)
        {
            archiveNameHash[l] = stream.readDWord();
            anIntArray729[l] = stream.read3Bytes();
            anIntArray730[l] = stream.read3Bytes();
            anIntArray731[l] = k;
            k += anIntArray730[l];
        }

    }
    public byte[] method571(String s) {
        byte[] abyte0 = null;
        int nameHash = 0;
        s = s.toUpperCase();
        for(int j = 0; j < s.length(); j++)
            nameHash = (nameHash * 61 + s.charAt(j)) - 32;

        for(int k = 0; k < dataSize; k++)
            if(archiveNameHash[k] == nameHash) {
                if(abyte0 == null)
                    abyte0 = new byte[anIntArray729[k]];
                if(!aBoolean732)
                {
                    BZip2Decompressor.getStreamAvailableOut(abyte0, anIntArray729[k], aByteArray726, anIntArray730[k], anIntArray731[k]);
                } else {
                    System.arraycopy(aByteArray726, anIntArray731[k], abyte0,
                            0, anIntArray729[k]);
                }
                return abyte0;
            }

        return null;
    }

    private byte aByte723;
    private int anInt724;
    private int anInt725;
    public byte aByteArray726[];
    public int dataSize;
    public int archiveNameHash[];
    public int anIntArray729[];
    public int anIntArray730[];
    public int anIntArray731[];
    private boolean aBoolean732;
}
