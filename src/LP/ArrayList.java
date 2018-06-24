package LP;

public class ArrayList<T> implements Atable<T>
{
    private Object[] arr;
    private int size;
    public ArrayList(int capacity)
    {
        arr=new Object[capacity];
        size=0;
    }
    public ArrayList()
    {
        this(128);
    }
    public void add(T item)
    {
        if(arr.length<=size)
        {
            Object[] N=new Object[arr.length*2];
            System.arraycopy(arr,0,N,0,arr.length);
            arr=N;
        }
        arr[size++]=item;
    }
    public void remove(int index)
    {
        if(index>=size||index<0) throw new IndexOutOfBoundsException(""+index);
        System.arraycopy(arr,index+1,arr,index,size-index-1);
        --size;
    }
    @Override
    public T at(int index)
    {
        if (index>=size||index<0) throw new IndexOutOfBoundsException(""+index);
        return (T)arr[index];
    }
    public T back()
    {
        return (T)arr[size-1];
    }
    @Override
    public int size()
    {
        return size;
    }
    public void set(int index, T item)
    {
        if (index>=size||index<0) throw new NullPointerException();
        arr[index]=item;
    }
}
