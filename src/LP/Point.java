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
        else if (this.y==o.y)
            return this.x<o.x?-1:1;
        return this.y<o.y?-1:1;
    }
    public static double distance_sqrt(Point a, Point b)
    {
        return (a.x-b.x)*(a.x-b.x)-(a.y-b.y)*(a.y-b.y);
    }
    @Override
    public String toString()
    {
        return "("+x+", "+y+")";
    }
}