package LP;

import LP.Atable;

public class Deque<T> implements Atable<T>
{
    private int tail, head, size;
    private Object[] A;
    public Deque(int capacity)
    {
        size=tail=head=0;
        A=new Object[capacity];
    }
    public Deque()
    {
        this(200);
    }
    public void push_back(T item)
    {
        ensure_capacity();
        A[tail]=item;
        tail=(tail+1)%A.length;
        ++size;
    }
    @Override
    public int size()
    {
        return size;
    }
    public boolean is_empty()
    {
        return size==0;
    }
    private boolean is_full()
    {
        return size==A.length;
    }
    private void ensure_capacity()
    {
        if (!is_full()) return;
        Object[] newA=new Object[A.length*2];
        for (int i=0;i<size;++i) newA[i]=at(i);
        head=0;
        tail=A.length;
        A=newA;
    }
    public T pop_front()
    {
        if(is_empty()) throw new NullPointerException();
        T r=(T)A[head];
        head=(head+1)%A.length;
        --size;
        return r;
    }
    public void push_front(T item)
    {
        ensure_capacity();
        head=(head-1+A.length)%A.length;
        A[head]=item;
        ++size;
    }
    public T pop_back()
    {
        if(is_empty()) throw new NullPointerException();
        tail=(tail-1+A.length)%A.length;
        --size;
        return (T)A[tail];
    }
    @Override
    public T at(int index)
    {
        if (index<0||index>=size) throw new IndexOutOfBoundsException(index);
        return (T)A[(head+index)%A.length];
    }
    public T front()
    {
        return at(0);
    }
    public T back()
    {
        return at(size-1);
    }
    public void set(int index, T item)
    {
        if (index<0||index>=size) throw new IndexOutOfBoundsException(index);
        A[(head+index)%A.length]=item;
    }
}
