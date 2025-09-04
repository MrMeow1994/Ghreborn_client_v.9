public final class DoubleEndedQueue
{

    public DoubleEndedQueue(int i)
    {
        aBoolean344 = false;
        anInt345 = -77;
        aNode_346 = new Node();
        if(i <= 0)
            aBoolean344 = !aBoolean344;
        aNode_346.prev = aNode_346;
        aNode_346.next = aNode_346;
    }

    public void insertHead(Node node)
    {
        if(node.next != null)
            node.unlink();
        node.next = aNode_346.next;
        node.prev = aNode_346;
        node.next.prev = node;
        node.prev.next = node;
    }

    public void method250(int i, Node node)
    {
        if(node.next != null)
            node.unlink();
        node.next = aNode_346;
        node.prev = aNode_346.prev;
        while(i >= 0) 
            aBoolean344 = !aBoolean344;
        node.next.prev = node;
        node.prev.next = node;
    }

    public Node method251()
    {
        Node node = aNode_346.prev;
        if(node == aNode_346)
        {
            return null;
        } else
        {
            node.unlink();
            return node;
        }
    }

    public Node reverseGetFirst()
    {
        Node node = aNode_346.prev;
        if(node == aNode_346)
        {
            aNode_347 = null;
            return null;
        } else
        {
            aNode_347 = node.prev;
            return node;
        }
    }

    public Node method253(int i)
    {
        if(i < 5 || i > 5)
            throw new NullPointerException();
        Node node = aNode_346.next;
        if(node == aNode_346)
        {
            aNode_347 = null;
            return null;
        } else
        {
            aNode_347 = node.next;
            return node;
        }
    }

    public Node reverseGetNext(boolean flag)
    {
        Node node = aNode_347;
        if(flag)
            anInt345 = 48;
        if(node == aNode_346)
        {
            aNode_347 = null;
            return null;
        } else
        {
            aNode_347 = node.prev;
            return node;
        }
    }

    public Node method255(int i)
    {
        Node node = aNode_347;
        if(node == aNode_346)
        {
            aNode_347 = null;
            return null;
        }
        aNode_347 = node.next;
        if(i != 8)
            throw new NullPointerException();
        else
            return node;
    }

    public void method256()
    {
        if(aNode_346.prev == aNode_346)
            return;
        do
        {
            Node node = aNode_346.prev;
            if(node == aNode_346)
                return;
            node.unlink();
        } while(true);
    }

    private boolean aBoolean344;
    private int anInt345;
    public Node aNode_346;
    private Node aNode_347;
}
