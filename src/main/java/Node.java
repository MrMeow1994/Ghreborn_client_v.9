
public class Node
{

    public void unlink() {
        if (next != null && prev != null) {
            next.prev = prev;
            prev.next = next;
        }
        prev = null;
        next = null;
    }

    public Node() {

    }

    public long uid;
    public Node prev;
    Node next;
}
