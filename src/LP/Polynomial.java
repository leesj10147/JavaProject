package LP;

public class Polynomial
{
    final public double A[];
    public Polynomial(double ...A)
    {
        this.A=A;
    }
    public double f(double x)
    {
        double res = 0, pw = 1;
        for (double d : A)
        {
            res += d * pw;
            pw *= x;
        }
        return res;
    }
    public Polynomial derivative()
    {
        double[] res=new double[A.length-1];
        for (int i=1;i<A.length;++i)
            res[i-1]=i*A[i];
        return new Polynomial(res);
    }
    public Polynomial integral(int C)
    {
        double[] res=new double[A.length+1];
        res[0]=C;
        for (int i=0;i<A.length;++i)
            res[i+1]=A[i]/(i+1);
        return new Polynomial(res);
    }
    public double definite_integral(int s, int e)
    {
        Polynomial t=integral(0);
        return t.f(e)-t.f(s);
    }
}
