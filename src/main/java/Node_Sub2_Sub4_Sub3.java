// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class Node_Sub2_Sub4_Sub3 extends Animable
{

    public Node_Sub2_Sub4_Sub3(int i, int j, int k, int l, int i1, int j1, int k1,
                               int l1)
    {
        aBoolean1565 = true;
        anInt1566 = 9;
        aBoolean1567 = false;
        aSpotAnimation_1568 = SpotAnimation.cache[i1];
        anInt1560 = i;
        anInt1561 = l1;
        anInt1562 = k1;
        anInt1563 = j1;
        anInt1564 = j + l;
        if(k != 6)
        {
            throw new NullPointerException();
        } else
        {
            aBoolean1567 = false;
            return;
        }
    }

    public final Model method444(int i)
    {
        if(i != 4016)
            throw new NullPointerException();
        Model model = aSpotAnimation_1568.method266();
        if(model == null)
            return null;
        int j = aSpotAnimation_1568.animationDefinition.frames[anInt1569];
        Model model_1 = new Model(9, true, FrameLoader.method532(j, false), false, model);
        if(!aBoolean1567)
        {
            model_1.createBones();
            model_1.method470(j, 40542);
            model_1.triangleSkin = null;
            model_1.vertexSkin = null;
        }
        if(aSpotAnimation_1568.anInt410 != 128 || aSpotAnimation_1568.anInt411 != 128)
            model_1.scaleT(aSpotAnimation_1568.anInt410, aSpotAnimation_1568.anInt410, anInt1566, aSpotAnimation_1568.anInt411);
        if(aSpotAnimation_1568.anInt412 != 0)
        {
            if(aSpotAnimation_1568.anInt412 == 90)
                model_1.method473(360);
            if(aSpotAnimation_1568.anInt412 == 180)
            {
                model_1.method473(360);
                model_1.method473(360);
            }
            if(aSpotAnimation_1568.anInt412 == 270)
            {
                model_1.method473(360);
                model_1.method473(360);
                model_1.method473(360);
            }
        }
        model_1.method479(64 + aSpotAnimation_1568.anInt413, 850 + aSpotAnimation_1568.anInt414, -30, -50, -30, true);
        return model_1;
    }

    public final void method454(int i, boolean flag)
    {
        if(!flag)
        {
            for(int j = 1; j > 0; j++);
        }
        for(anInt1570 += i; anInt1570 > aSpotAnimation_1568.animationDefinition.method258(anInt1569, (byte)-39);)
        {
            anInt1570 -= aSpotAnimation_1568.animationDefinition.method258(anInt1569, (byte)-39) + 1;
            anInt1569++;
            if(anInt1569 >= aSpotAnimation_1568.animationDefinition.frameCount && (anInt1569 < 0 || anInt1569 >= aSpotAnimation_1568.animationDefinition.frameCount))
            {
                anInt1569 = 0;
                aBoolean1567 = true;
            }
        }

    }

    public int anInt1560;
    public int anInt1561;
    public int anInt1562;
    public int anInt1563;
    public int anInt1564;
    private boolean aBoolean1565;
    private int anInt1566;
    public boolean aBoolean1567;
    private SpotAnimation aSpotAnimation_1568;
    private int anInt1569;
    private int anInt1570;
}
