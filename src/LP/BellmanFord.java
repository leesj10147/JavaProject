package LP;

public class BellmanFord implements ShortestPathAble
{
    private class Edge
    {
        private int from, to, weight;
        private Edge(int from, int to, int weight)
        {
            this.from=from;
            this.to=to;
            this.weight=weight;
        }
    }
    private ArrayList<Edge> E;
    private final int MAX_N;
    public BellmanFord(int MAX_N)
    {
        E=new ArrayList<>();
        this.MAX_N=MAX_N;
    }
    public void addEdge(int from, int to, int weight)
    {
        E.add(new Edge(from, to, weight));
    }
    @Override
    public int[] getShortestPath(int start)
    {
        int[] dist=new int[MAX_N+1];
        Algorithm.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;
        for(int i=1;i<=MAX_N-1;++i)
        {
            for (int j = 0; j < E.size(); ++j)
            {
                Edge e = E.at(j);
                int from = e.from;
                int to = e.to;
                int weight = e.weight;
                if (dist[from] == Integer.MAX_VALUE) continue;
                dist[to] = MATH.min(dist[to], dist[from] + weight);
            }
        }
        for (int i=0;i<E.size();++i)
        {
            Edge e=E.at(i);
            int from=e.from;
            int to=e.to;
            int weight=e.weight;
            if(dist[from]==Integer.MAX_VALUE) continue;
            if(dist[from]+weight<dist[to]) throw new NegativeCycleException();
        }
        return dist;
    }
}
