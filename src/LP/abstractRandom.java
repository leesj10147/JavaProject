package LP;

public abstract class abstractRandom
{
    public long get_value(long minVal, long maxVal)//[minVal, maxVal]
    {
        return minVal+(MATH.abs(get_value())%(maxVal-minVal+1));
    }
    public abstract long get_value();
}
