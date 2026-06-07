class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        FindRelations rel = new FindRelations(n);

        for(int[] e : edges)
        {
            int a = e[0];
            int b = e[1];

            boolean isCycle = rel.unionSet(a, b);
            if(isCycle)
            {
                return e;
            }
        }
        return edges[n-1];
    }
}

class FindRelations
{
    int n;
    int[] parent;
    int[] rank;

    FindRelations(int n)
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
}
