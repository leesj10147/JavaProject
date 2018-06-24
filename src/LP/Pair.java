package LP;

public class Pair<T1, T2> implements Comparable<Pair<T1, T2>>
{
    public T1 first;
    public T2 second;
    public Pair(T1 first, T2 second)
    {
        this.first=first;
        this.second=second;
    }

    @Override
    public int compareTo(Pair<T1,T2> o)
    {
        if(((Comparable)o.first).compareTo(this.first)==0)
            return ((Comparable)this.second).compareTo(o.second);
        return ((Comparable)this.first).compareTo(o.first);
    }
}
