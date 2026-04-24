class Solution {
    public int minCostConnectPoints(int[][] points) 
    {
        int n = points.length;

        if(n <= 1)
            return 0;
        

        int[][] graph = new int[(n * (n-1))/2][3];
        int c = 0;

        //making graphs from the points
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                int x1 = points[i][0];
                int x2 = points[j][0];

                int y1 = points[i][1];
                int y2 = points[j][1];

                int dis = Math.abs(x1-x2) + Math.abs(y1-y2);
                graph[c++] = new int[]{i, j, dis};
            }
        }

        //sorting the graph by distance
        Arrays.sort(graph, (a, b) -> Integer.compare(a[2], b[2]));

        FindRelation rel = new FindRelation(graph.length);

        int cost = 0, count = 0;

        for(int[] g : graph)
        {
            int a = g[0];
            int b = g[1];
            int w = g[2];

            if(rel.formUnionSet(a, b))
            {
                cost = cost + w;
                if(++count == graph.length-1)
                    break;
            }
        }
        return cost;
    }
}

class FindRelation
{
    int n;
    int[] parent;
    int[] rank;

    FindRelation(int n)
    {
        this.n = n;
        this.parent = new int[n+1];
        this.rank = new int[n+1];

        for(int i = 1; i <= n; i++)
            parent[i] = i;
    }

    public int findParent(int n)
    {
        int nParent = parent[n];
        if(n == nParent)
            return n;
        return findParent(nParent);
    }

    public boolean formUnionSet(int a, int b)
    {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(parentA == parentB)
            return false;

        int rankA = rank[parentA];
        int rankB = rank[parentB];

        if(rankA > rankB)
            parent[parentB] = parentA;
        else if(rankB > rankA)
            parent[parentA] = parentB;
        else
        {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
        return true;
    }
}
