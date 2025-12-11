// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class Skinlist
{
    public int[] opcodes;
    public int[][] skinList;

    public Skinlist(Stream stream, int junk)
    {
        int anInt341 = stream.readUnsignedShort();
        opcodes = new int[anInt341];
        skinList = new int[anInt341][];
        for(int j = 0; j < anInt341; j++)
            opcodes[j] = stream.readUnsignedShort();

	for(int j = 0; j < anInt341; j++)
	    skinList[j] = new int[stream.readUnsignedShort()];

        for(int j = 0; j < anInt341; j++)
		for (int l = 0; l < skinList[j].length; l++)
			skinList[j][l] = stream.readUnsignedShort();
    }


}
