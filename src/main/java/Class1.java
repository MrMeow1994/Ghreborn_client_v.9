import sign.signlink;

public final class Class1
{

    public Class1(int i, int j)
    {
        aBoolean37 = false;
        anInt38 = -373;
        if(i >= 0)
            throw new NullPointerException();
        anInt39 = j;
        aNodeArray40 = new Node[j];
        for(int k = 0; k < j; k++)
        {
            Node node = aNodeArray40[k] = new Node();
            node.prev = node;
            node.next = node;
        }

    }

    public Node method148(long l)
    {
        Node node = aNodeArray40[(int)(l & (long)(anInt39 - 1))];
        for(Node node_1 = node.prev; node_1 != node; node_1 = node_1.prev)
            if(node_1.uid == l)
                return node_1;

        return null;
    }

    public void method149(Node node, long l, byte byte0)
    {
        try
        {
            if(node.next != null)
                node.unlink();
            Node node_1 = aNodeArray40[(int)(l & (long)(anInt39 - 1))];
            if(byte0 != 7)
            {
                return;
            } else
            {
                node.next = node_1.next;
                node.prev = node_1;
                node.next.prev = node;
                node.prev.next = node;
                node.uid = l;
                return;
            }
        }
        catch(RuntimeException runtimeexception)
        {
            signlink.reporterror("91499, " + node + ", " + l + ", " + byte0 + ", " + runtimeexception.toString());
        }
        throw new RuntimeException();
    }

    private boolean aBoolean37;
    private int anInt38;
    private int anInt39;
    private Node aNodeArray40[];
}
