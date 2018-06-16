public class Stack<T>
{
    private class Node
    {
        public T obj;
        Node back;
        public Node(T obj)
        {
            this.obj=obj;
            back=null;
        }
    }
    private Node top;
    public Stack()
    {
        top=null;
    }
    public void push(T obj)
    {
        if (top == null) top=new Node(obj);
        else
        {
            Node t=new Node(obj);
            t.back=top;
            top=t;
        }
    }
    public T pop()
    {
        Node n=top;
        top=top.back;
        return n.obj;
    }
    public boolean is_empty()
    {
        return top==null;
    }
}
