package LP;

public class WELL512Random extends abstractRandom
{
    private final long DIFFER_VALUE=123;
    private long[] state=new long[16];
    private int index=0;
    public WELL512Random(long seed)
    {
        long s=seed;
        for (int i=0;i<16;++i)
        {
            state[i]=s;
            s+=DIFFER_VALUE;
        }
    }
    public WELL512Random()
    {
        this(System.currentTimeMillis());
    }
    @Override
    public long get_value()
    {
        long a, b, c, d;
        a=state[index];
        c=state[(index+13)&15];
        b=a^c^(a<<16)^(c<<15);
        c=state[(index+9)&15];
        c^=(c>>11);
        a=state[index]=b^c;
        d=a^((a<<5)&0xda442d24L);
        index=(index+15)&15;
        a=state[index];
        state[index]=a^b^d^(a<<2)^(b<<18)^(c<<28);
        return state[index];
    }
}
