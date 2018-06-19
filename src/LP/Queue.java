package LP;

public class Queue<T>
{
    private class Node
    {
        private T obj;
        private Node back, next;
        private Node(T obj)
        {
            this.obj=obj;
        }
    }
    private Node tail, head;
    public Queue()
    {
        tail=head=null;
    }
    public void push(T a)
    {
        if (head==null)
        {
            tail=head=new Node(a);
            return;
        }
        Node t=new Node(a);
        t.next=tail;
        tail.back=t;
        tail=t;
    }
    public T pop()
    {
        if (is_empty()) throw new NullPointerException();
        Node r=head;
        head=head.back;
        return r.obj;
    }
    public boolean is_empty()
    {
        return head==null;
    }
    public T front()
    {
        return head.obj;
    }
}
