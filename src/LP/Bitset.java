package LP;

public class Bitset implements Atable<Boolean>
{
    private int A[], size;
    public Bitset(int size)
    {
        this.size=size;
        A=new int[size/32+1];
    }
    @Override
    public Boolean at(int index)
    {
        return ((A[index/32]>>(index%32))&1)==1;
    }

    @Override
    public void set(int index, Boolean item)
    {
        A[index/32]=item?(A[index/32]|1<<(index%32)):(A[index/32]&0<<(index%32));
    }

    @Override
    public int size()
    {
        return size;
    }
}
