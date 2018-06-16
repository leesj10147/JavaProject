public class ArrayList<T> implements Atable
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
        this(100);
    }
    public void add(T item)
    {
        if(arr.length<=size)
        {
            Object[] N=new Object[arr.length*10];
            System.arraycopy(arr,0,N,0,arr.length);
            arr=N;
        }
        arr[size++]=item;
    }
    public void remove(int index)
    {
        if(index>=size||index<0) throw new NullPointerException();
        System.arraycopy(arr,index+1,arr,index,arr.length-index-1);
        --size;
    }
    @Override
    public Object at(int index)
    {
        if (index>=size||index<0) throw new NullPointerException();
        return arr[index];
    }
    public int size()
    {
        return size;
    }
}
