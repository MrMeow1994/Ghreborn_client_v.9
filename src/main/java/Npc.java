// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

final class Npc extends Class30_Sub2_Sub4_Sub1
{

    final Model method450(int i)
    {
        if(i != 0)
        {
            for(int j = 1; j > 0; j++);
        }
        if(super.primaryanim >= 0 && super.primaryanim_pause == 0)
        {
            int k = AnimationDefinition.anims[super.primaryanim].frames[super.primaryanim_frameindex];
            int i1 = -1;
            if(super.anInt1517 >= 0 && super.anInt1517 != super.anInt1511)
                i1 = AnimationDefinition.anims[super.anInt1517].frames[super.anInt1518];
            return desc.method164(0, i1, k, AnimationDefinition.anims[super.primaryanim].anIntArray357);
        }
        int l = -1;
        if(super.anInt1517 >= 0)
            l = AnimationDefinition.anims[super.anInt1517].frames[super.anInt1518];
        return desc.method164(0, -1, l, null);
    }

    public final Model method444(int i)
    {
        if(desc == null)
            return null;
        Model model = method450(0);
        if(model == null)
            return null;
        super.anInt1507 = ((Animable) (model)).anInt1426;
        if(i != 4016)
            anInt1693 = -403;
        if(super.anInt1520 != -1 && super.anInt1521 != -1)
        {
            Class23 class23 = Class23.aClass23Array403[super.anInt1520];
            Model model_1 = class23.method266();
            if(model_1 != null)
            {
                int j = class23.aClass20_407.frames[super.anInt1521];
                Model class30_sub2_sub4_sub6_2 = new Model(9, true, Class36.method532(j, false), false, model_1);
                class30_sub2_sub4_sub6_2.method475(0, -super.anInt1524, 16384, 0);
                class30_sub2_sub4_sub6_2.method469((byte)-71);
                class30_sub2_sub4_sub6_2.method470(j, 40542);
                class30_sub2_sub4_sub6_2.anIntArrayArray1658 = null;
                class30_sub2_sub4_sub6_2.anIntArrayArray1657 = null;
                if(class23.anInt410 != 128 || class23.anInt411 != 128)
                    class30_sub2_sub4_sub6_2.method478(class23.anInt410, class23.anInt410, anInt1695, class23.anInt411);
                class30_sub2_sub4_sub6_2.method479(64 + class23.anInt413, 850 + class23.anInt414, -30, -50, -30, true);
                Model aclass30_sub2_sub4_sub6[] = {
                        model, class30_sub2_sub4_sub6_2
                };
                model = new Model(2, -819, true, aclass30_sub2_sub4_sub6);
            }
        }
        if(desc.aByte68 == 1)
            model.aBoolean1659 = true;
        return model;
    }

    public final boolean method449(boolean flag)
    {
        if(!flag)
            aBoolean1694 = !aBoolean1694;
        return desc != null;
    }

    Npc()
    {
        aBoolean1694 = false;
        anInt1695 = 9;
    }

    private int anInt1693;
    private boolean aBoolean1694;
    private int anInt1695;
    Class5 desc;
}
