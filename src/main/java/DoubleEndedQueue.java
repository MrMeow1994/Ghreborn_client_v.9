public final class DoubleEndedQueue
{

    public DoubleEndedQueue(int i)
    {
        aBoolean344 = false;
        anInt345 = -77;
        aClass30_346 = new Class30();
        if(i <= 0)
            aBoolean344 = !aBoolean344;
        aClass30_346.aClass30_549 = aClass30_346;
        aClass30_346.aClass30_550 = aClass30_346;
    }

    public void insertHead(Class30 class30)
    {
        if(class30.aClass30_550 != null)
            class30.unlink();
        class30.aClass30_550 = aClass30_346.aClass30_550;
        class30.aClass30_549 = aClass30_346;
        class30.aClass30_550.aClass30_549 = class30;
        class30.aClass30_549.aClass30_550 = class30;
    }

    public void method250(int i, Class30 class30)
    {
        if(class30.aClass30_550 != null)
            class30.unlink();
        class30.aClass30_550 = aClass30_346;
        class30.aClass30_549 = aClass30_346.aClass30_549;
        while(i >= 0) 
            aBoolean344 = !aBoolean344;
        class30.aClass30_550.aClass30_549 = class30;
        class30.aClass30_549.aClass30_550 = class30;
    }

    public Class30 method251()
    {
        Class30 class30 = aClass30_346.aClass30_549;
        if(class30 == aClass30_346)
        {
            return null;
        } else
        {
            class30.unlink();
            return class30;
        }
    }

    public Class30 reverseGetFirst()
    {
        Class30 class30 = aClass30_346.aClass30_549;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        } else
        {
            aClass30_347 = class30.aClass30_549;
            return class30;
        }
    }

    public Class30 method253(int i)
    {
        if(i < 5 || i > 5)
            throw new NullPointerException();
        Class30 class30 = aClass30_346.aClass30_550;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        } else
        {
            aClass30_347 = class30.aClass30_550;
            return class30;
        }
    }

    public Class30 reverseGetNext(boolean flag)
    {
        Class30 class30 = aClass30_347;
        if(flag)
            anInt345 = 48;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        } else
        {
            aClass30_347 = class30.aClass30_549;
            return class30;
        }
    }

    public Class30 method255(int i)
    {
        Class30 class30 = aClass30_347;
        if(class30 == aClass30_346)
        {
            aClass30_347 = null;
            return null;
        }
        aClass30_347 = class30.aClass30_550;
        if(i != 8)
            throw new NullPointerException();
        else
            return class30;
    }

    public void method256()
    {
        if(aClass30_346.aClass30_549 == aClass30_346)
            return;
        do
        {
            Class30 class30 = aClass30_346.aClass30_549;
            if(class30 == aClass30_346)
                return;
            class30.unlink();
        } while(true);
    }

    private boolean aBoolean344;
    private int anInt345;
    public Class30 aClass30_346;
    private Class30 aClass30_347;
}
