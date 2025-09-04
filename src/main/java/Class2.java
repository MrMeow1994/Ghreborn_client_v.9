public final class Class2
{

    public Class2(int i)
    {
        aBoolean41 = false;
        anInt42 = -589;
        aClass30_Sub2_43 = new Node_Sub2();
        if(i != 0)
            anInt42 = -25;
        aClass30_Sub2_43.aClass30_Sub2_1303 = aClass30_Sub2_43;
        aClass30_Sub2_43.aClass30_Sub2_1304 = aClass30_Sub2_43;
    }

    public void method150(Node_Sub2 class30_sub2)
    {
        if(class30_sub2.aClass30_Sub2_1304 != null)
            class30_sub2.method330();
        class30_sub2.aClass30_Sub2_1304 = aClass30_Sub2_43.aClass30_Sub2_1304;
        class30_sub2.aClass30_Sub2_1303 = aClass30_Sub2_43;
        class30_sub2.aClass30_Sub2_1304.aClass30_Sub2_1303 = class30_sub2;
        class30_sub2.aClass30_Sub2_1303.aClass30_Sub2_1304 = class30_sub2;
    }

    public Node_Sub2 method151()
    {
        Node_Sub2 class30_sub2 = aClass30_Sub2_43.aClass30_Sub2_1303;
        if(class30_sub2 == aClass30_Sub2_43)
        {
            return null;
        } else
        {
            class30_sub2.method330();
            return class30_sub2;
        }
    }

    public Node_Sub2 method152()
    {
        Node_Sub2 class30_sub2 = aClass30_Sub2_43.aClass30_Sub2_1303;
        if(class30_sub2 == aClass30_Sub2_43)
        {
            aClass30_Sub2_44 = null;
            return null;
        } else
        {
            aClass30_Sub2_44 = class30_sub2.aClass30_Sub2_1303;
            return class30_sub2;
        }
    }

    public Node_Sub2 method153(boolean flag)
    {
        if(flag)
            throw new NullPointerException();
        Node_Sub2 class30_sub2 = aClass30_Sub2_44;
        if(class30_sub2 == aClass30_Sub2_43)
        {
            aClass30_Sub2_44 = null;
            return null;
        } else
        {
            aClass30_Sub2_44 = class30_sub2.aClass30_Sub2_1303;
            return class30_sub2;
        }
    }

    public int method154()
    {
        int i = 0;
        for(Node_Sub2 class30_sub2 = aClass30_Sub2_43.aClass30_Sub2_1303; class30_sub2 != aClass30_Sub2_43; class30_sub2 = class30_sub2.aClass30_Sub2_1303)
            i++;

        return i;
    }

    private boolean aBoolean41;
    private int anInt42;
    public Node_Sub2 aClass30_Sub2_43;
    private Node_Sub2 aClass30_Sub2_44;
}
