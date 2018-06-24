package LP;

public class Dijikstra implements ShortestPathAble
{
    private ArrayList<Pair<Integer, Integer>>[] graph;
    public Dijikstra(int MAX_N)
    {
        graph=new ArrayList[MAX_N+1];
        for (int i=0;i<=MAX_N;++i) graph[i]=new ArrayList<>();
    }
    public void addEdge(int from, int to, int weight)
    {
        if (weight<0) throw new NegativeNodeException();
        graph[from].add(new Pair<>(weight, to));
    }

    @Override
    public int[] getShortestPath(int start)
    {
        int[] dist=new int[graph.length];
        Algorithm.fill(dist, Integer.MAX_VALUE);
        priority_queue<Pair<Integer,Integer>> Q=new priority_queue<>(Algorithm.greater());
        Q.push(new Pair<>(0, start));
        dist[start]=0;
        while(!Q.is_empty())
        {
            Pair<Integer, Integer> n=Q.top();
            Q.pop();
            if (n.first!= dist[n.second]) continue;
            for (int i=0;i<graph[n.second].size();++i)
            {
                Pair<Integer, Integer> p=graph[n.second].at(i);
                int nV=dist[n.second]+p.first;
                if(nV<dist[p.second])
                {
                    dist[p.second]=nV;
                    Q.push(new Pair(dist[p.second], p.second));
                }
            }
        }


        return dist;
    }
}
