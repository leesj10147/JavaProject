package LP;

public interface Atable<T>
{
    public abstract T at(int index);
    public abstract void set(int index, T item);
    public abstract int size();
    public default void swap(int index1, int index2)
    {
        T tmp=at(index1);
        set(index1, at(index2));
        set(index2, tmp);
    }
}
