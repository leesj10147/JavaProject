package LP;

import java.util.Comparator;

public class priority_queue<T>
{
    private ArrayList<T> v;
    private Comparator<? super T> comp;
    public priority_queue(Comparator<? super T> comparator)
    {
        this.comp=comparator;
        v=new ArrayList<>();
    }
    public priority_queue()
    {
        this((o1, o2)-> ((Comparable)o1).compareTo(o2));
    }
    private int patent(int i)
    {
        return (i-1)/2;
    }
    private int right(int i)
    {
        return 2*i+2;
    }
    private int left(int i)
    {
        return 2*i+1;
    }
    private void maxHeapify(int i)
    {
        int l=left(i);
        int r=right(i);
        int largest=i;
        if(l<v.size() && comp.compare(v.at(l),v.at(largest))>0)
            largest=l;
        if(r<v.size() && comp.compare(v.at(l),v.at(largest))>0)
            largest=r;
        if(largest!=i)
        {
            v.swap(i, largest);
            maxHeapify(largest);
        }
    }
    public T top()
    {
        return v.at(0);
    }
    public void pop()
    {
        if(v.size()<1) return;
        v.set(0, v.at(v.size()-1));
        v.remove(v.size()-1);
        maxHeapify(0);
    }
    public void push(T item)
    {
        v.add(null);
        int i=v.size()-1;
        while(i>0&&comp.compare(v.at(patent(i)),item)<0)
        {
            v.set(i, v.at(patent(i)));
            i=patent(i);
        }
        v.set(i, item);
    }
    public int size()
    {
        return v.size();
    }
    public boolean is_empty()
    {
        return v.size()==0;
    }
}
