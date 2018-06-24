package LP;

public class MATH
{
    private MATH() { }

    public static final double PI = 3.14159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196442881097566593344612847564823378678316527120190914564856692346034861045432664821339360726024914127372458700660631558817488152092096282925409171536436789259036001133053054882046652138414695194151160943305727036575959195309218611738193261179;
    public static int gcd(int a, int b)
    {
        int t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public static long gcd(long a, long b)
    {
        long t;
        while(b!=0)
        {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    public static int lcm(int a, int b)
    {
        return a*b/gcd(a, b);
    }
    public static long lcm(long a, long b)
    {
        return a*b/gcd(a,b);
    }
    public static double newton_raphson(Polynomial p, double start, int cnt)
    {
        Polynomial der=p.derivative();
        double now=start;
        while(cnt--!=0)
            now -= p.f(now) / der.f(now);
        return now;
    }
    public static double root(double a)
    {
        return newton_raphson(new Polynomial(-a,0,1), a, 32);
    }
    public static<T> T min(T ...a)
    {
        if(a.length==0) return null;
        T res=a[0];
        for(T i : a) res=((Comparable)res).compareTo(i)>0?i:res;
        return res;
    }
    public static int max(int ...a)
    {
        int res=Integer.MIN_VALUE;
        for(int i:a)res=i>res?i:res;
        return res;
    }
    public static long pow(long basis, long exponent)
    {
        long res=1;
        while(exponent!=0)
        {
            if((exponent&1)==1) res*=basis;
            basis=basis*basis;
            exponent>>=1;
        }
        return res;
    }
    public static long pow(long basis, long exponent, long MOD)
    {
        long res=1;
        while(exponent!=0)
        {
            if((exponent&1)==1)
                res=russian_farmer(res,basis,MOD);
            basis=russian_farmer(basis,basis,MOD);
            exponent>>=1;
        }
        return res;
    }
    public static long russian_farmer(long a, long b, long MOD)
    {
        long res=0;
        while(b!=0)
        {
            if((b&1)==1)
            {
                res+=a;
                res%=MOD;
            }
            a<<=1;
            a%=MOD;
            b>>=1;
        }
        return res;
    }
    public static long abs(long a)
    {
        return a<0?-a:a;
    }
    public static ArrayList<Integer> get_prime(int MAX_N)
    {
        Bitset nP=new Bitset(MAX_N);
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=2;i<=MAX_N;++i)
        {
            if(nP.at(i)==true) continue;
            res.add(i);
            for (int j=i*i;j<=MAX_N&&j>i;j+=i) nP.set(j, true);
        }
        return res;
    }
    public static int length_of_LIS(int[] A)
    {
        ArrayList<Integer> R=new ArrayList<>();
        R.add(Integer.MAX_VALUE);
        for(int i=0;i<A.length;++i)
        {
            if(R.back()<A[i]) R.add(A[i]);
            else R.set(Algorithm.lower_bound(R, A[i]), A[i]);
        }
        return R.size();
    }
}