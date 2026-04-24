class Solution {

    int n;
    int[] parent;
    int[] rank;


    public int findParent(int n)
    {
        int nParent = parent[n];
        if(nParent == n)
            return n;
        
        return findParent(nParent);
    }

    public boolean unionSet(int a, int b)
    {
        int parentA = findParent(a);
        int parentB = findParent(b);


        if(parentA == parentB)
        {
            return true;
        }

        int rankA = rank[parentA];
        int rankB = rank[parentB];

        if(rankA > rankB)
        {
            parent[parentB] = parentA;
        }
        else if(rankB > rankA)
        {
            parent[parentA] = parentB;
        }
        else
        {
            parent[parentB] = parentA;
            rank[parentA]++;
        }

        return false;

    }

    public int[] findRedundantConnection(int[][] edges) {

        n = edges.length;
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i = 1; i <= n; i++)
            parent[i] = i;

        for(int[] e : edges)
        {
            int a = e[0];
            int b = e[1];


            boolean isCycle = unionSet(a, b);
            if(isCycle)
            {
                return e;
            }
        }
        return edges[n-1];
    }
}
