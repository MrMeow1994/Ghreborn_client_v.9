// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

public class SpotAnimation
{

    public static void method264(int i, FileArchive fileArchive)
    {
        Stream stream = new Stream(fileArchive.method571("spotanim.dat"));
        anInt402 = stream.readUnsignedShort();
        if(cache == null)
            cache = new SpotAnimation[anInt402];
        for(int j = 0; j < anInt402; j++)
        {
            if(cache[j] == null)
                cache[j] = new SpotAnimation();
            cache[j].anInt404 = j;
            cache[j].method265(stream);
		}
    }
	public void method265(Stream stream) {
        do {
    int i = stream.readUnsignedByte();
    if (i == 0)
        return;
    if (i == 1)
        anInt405 = stream.readUnsignedShort();
    else if (i == 2) {
        anInt406 = stream.readUnsignedShort();
        if (AnimationDefinition.anims != null)
            animationDefinition = AnimationDefinition.anims[anInt406];
    } else if (i == 4)
        anInt410 = stream.readUnsignedShort();
    else if (i == 5)
        anInt411 = stream.readUnsignedShort();
    else if (i == 6)
        anInt412 = stream.readUnsignedShort();
    else if (i == 7)
        anInt413 = stream.readUnsignedByte();
    else if (i == 8)
        anInt414 = stream.readUnsignedByte();
    else if (i == 40) {
        int j = stream.readUnsignedByte();
        for (int k = 0; k < j; k++) {
            anIntArray408[k] = stream.readUnsignedShort();
            anIntArray409[k] = stream.readUnsignedShort();
        }
    } else
        System.out.println("Error unrecognised spotanim config code: "
                + i);
} while (true);
}

    public Model method266()
    {
        Model model = (Model)aClass12_415.method222(anInt404);
        if(model != null)
            return model;
        model = Model.method462(anInt400, anInt405);
        if(model == null)
            return null;
        for(int i = 0; i < 6; i++)
            if(anIntArray408[0] != 0)
                model.method476(anIntArray408[i], anIntArray409[i]);

        aClass12_415.method223(model, anInt404, (byte)2);
        return model;
    }

    public SpotAnimation()
    {
        anInt400 = 9;
        anInt406 = -1;
        anIntArray408 = new int[11];
        anIntArray409 = new int[11];
        anInt410 = 128;
        anInt411 = 128;
    }

    private int anInt400;
    private static boolean aBoolean401 = true;
    public static int anInt402;
    public static SpotAnimation cache[];
    public int anInt404;
    public int anInt405;
    public int anInt406;
    public AnimationDefinition animationDefinition;
    public int anIntArray408[];
    public int anIntArray409[];
    public int anInt410;
    public int anInt411;
    public int anInt412;
    public int anInt413;
    public int anInt414;
    public static Class12 aClass12_415 = new Class12(false, 30);

}