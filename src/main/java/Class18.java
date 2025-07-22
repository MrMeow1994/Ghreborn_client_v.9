// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class Class18
{
    public Class18(Stream stream, int junk)
    {
        int anInt341 = stream.readUnsignedShort();
	anIntArray342 = new int[anInt341];
        anIntArrayArray343 = new int[anInt341][];
        for(int j = 0; j < anInt341; j++)
            anIntArray342[j] = stream.readUnsignedShort();

	for(int j = 0; j < anInt341; j++)
	    anIntArrayArray343[j] = new int[stream.readUnsignedShort()];

        for(int j = 0; j < anInt341; j++)
		for (int l = 0; l < anIntArrayArray343[j].length; l++)
			anIntArrayArray343[j][l] = stream.readUnsignedShort();
    }

    private int anInt340;
    public int anInt341;
    public int anIntArray342[];
    public int anIntArrayArray343[][];
}
