package LP;

public class Algorithm
{
    private Algorithm(){}
    //[s1,e1], [s2,e2]
    private static void merge(Atable list, int s1, int e1, int s2, int e2)
    {
        Object[] res=new Object[e2-s1+1];
        int idx=0;
        while(s1<=e1&&s2<=e2)
            if (((Comparable) list.at(s1)).compareTo(list.at(s2)) < 0)
                res[idx++] = list.at(s1++);
            else
                res[idx++] = list.at(s2++);
        while(s1<=e1)
            res[idx++] = list.at(s1++);
        while(s2<=e2)
            res[idx++] = list.at(s2++);
        for (int i=res.length-1;i>=0;--i) list.set(i-res.length+e2+1, res[i]);
    }
    //[s,e]
    public static void merge_sort(Atable list, int s, int e)
    {
        if(s>=e) return;
        int mid=(s+e)/2;
        merge_sort(list, s,mid);
        merge_sort(list, mid+1, e);
        merge(list,s,mid,mid+1,e);
    }
    public static void merge_sort(Atable list)
    {
        merge_sort(list, 0, list.size()-1);
    }
    //[s,e]
    public static<T> boolean binary_search(Atable<T> list, int s, int e, T obj)
    {
        int mid;
        Comparable tmp;
        while(s<=e)
        {
            mid=(s+e)/2;
            tmp=(Comparable<? super T>)list.at(mid);
            if(tmp.equals(obj)) return true;
            else if (tmp.compareTo(obj)>0) e=mid-1;
            else s=mid+1;
        }
        return false;
    }
    //return index
    public static<T> int lower_bound(Atable<T> list, int s, int len, T obj)
    {
        int e=s+len, mid;
        Comparable tmp;
        while(s<e)
        {
            mid=(s+e)/2;
            tmp=(Comparable<? super T>)list.at(mid);
            if (tmp.compareTo(obj)<0)
                s=mid+1;
            else
                e=mid;
        }
        return e;
    }
    public static<T> int lower_bound(Atable<T> list, T obj)
    {
        return lower_bound(list, 0, list.size(), obj);
    }
    //초과최소 return index
    public static<T> int upper_bound(Atable<T> list, int s, int len, T obj)
    {
        int e=s+len, mid;
        Comparable tmp;
        while(s<e)
        {
            mid=(s+e)/2;
            tmp=(Comparable<? super T>)list.at(mid);
            if (tmp.compareTo(obj)>0)
                e=mid;
            else
                s=mid+1;
        }
        return e;
    }
    public static<T> Pair<Integer, Integer> equal_range(Atable<T> list, int s, int len, T obj)
    {
        return new Pair<Integer, Integer>(lower_bound(list,s,len,obj), upper_bound(list,s,len,obj)-1);
    }
    public static<T> Pair<Integer, Integer> equal_range(Atable<T> list, T obj)
    {
        return equal_range(list, 0, list.size(), obj);
    }
    public static<T> int upper_bound(Atable<T> list, T obj)
    {
        return upper_bound(list, 0, list.size(), obj);
    }
    public static<T> boolean binary_search(Atable<T> list, T obj)
    {
        return binary_search(list,0,list.size()-1, obj);
    }
    //[s,e]
    public static void insertion_sort(Atable list, int s, int e)
    {
        for (int i=s+1,index=i;i<=e;++i,index=i)
            while(index>0 && ((Comparable)list.at(index)).compareTo(list.at(index-1))<0)
                list.swap(index,--index);
    }
    public static void insertion_sort(Atable list)
    {
        insertion_sort(list, 0, list.size()-1);
    }
    //[s,e]
    public static boolean is_Ascending(Atable list, int s, int e)
    {
        for (int i=s+1;i<=e;++i)
            if (((Comparable)list.at(i-1)).compareTo(list.at(i))>0) return false;
        return true;
    }
    //[s,e]
    public static boolean is_Descending(Atable list, int s, int e)
    {
        for (int i=s+1;i<=e;++i)
            if (((Comparable)list.at(i-1)).compareTo(list.at(i))<0) return false;
        return true;
    }
    public static boolean is_Ascending(Atable list)
    {
        return is_Ascending(list, 0, list.size()-1);
    }
    public static boolean is_Descending(Atable list)
    {
        return is_Descending(list, 0, list.size()-1);
    }
    //[s,e]
    public static void fast_sort(Atable list, int s, int e)
    {
        if (e-s<=64)
        {
            insertion_sort(list, s, e);
            return;
        }
        int mid=(s+e)/2;
        fast_sort(list, s, mid);
        fast_sort(list, mid+1, e);
        merge(list, s, mid, mid+1, e);
    }
    public static void fast_sort(Atable list)
    {
        fast_sort(list, 0, list.size()-1);
    }
}
