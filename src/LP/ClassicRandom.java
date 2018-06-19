package LP;

public class ClassicRandom extends abstractRandom
{
    private long Xn;
    private static long a=1664525L;
    private static long c=1013904223L;
    private static long m=2L<<32;
    public ClassicRandom(long seed)
    {
        Xn=seed;
    }
    public ClassicRandom()
    {
        this(System.currentTimeMillis());
    }
    @Override
    public long get_value()
    {
        return Xn=(a*Xn+c)%m;
    }
}
