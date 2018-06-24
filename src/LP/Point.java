package LP;

public class Point implements Comparable<Point>
{
    public double x, y;
    public Point(double x, double y)
    {
        this.x=x;
        this.y=y;
    }
    public Point(){}
    public static double ccw(Point a, Point b, Point c)
    {
        return  (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    @Override
    public int compareTo(Point o)
    {
        if (this.x==o.x&&this.y==o.y) return 0;
        else if (this.x==o.x)
            return this.y<o.y?-1:1;
        return this.x<o.x?-1:1;
    }
    @Override
    public String toString()
    {
        return "("+x+", "+y+")";
    }
}