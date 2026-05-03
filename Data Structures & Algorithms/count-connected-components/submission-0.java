class Solution {
    public int countComponents(int n, int[][] edges) {

        FindRelations rel = new FindRelations(n);
        for(int[] connections : edges)
        {
            int a = connections[0];
            int b = connections[1];

            rel.findUnionSet(a, b);
        }

        return rel.checkAllParents();
    }
}

class FindRelations
{
    int n;
    int[] rank;
    int[] parent;

    FindRelations(int n)
    {
        this.n = n;
        this.rank = new int[n];
        this.parent = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int findParent(int node)
    {
        int nodeParent = parent[node];
        if(node == nodeParent)
            return node;
        return findParent(nodeParent);
    }

    public boolean findUnionSet(int a, int b)
    {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if(parentA == parentB)
            return false;
        
        int rankA = rank[parentA];
        int rankB = rank[parentB];

        if(rankA < rankB)
        {
            parent[parentA] = parentB;
        }
        else if(rankB < rankA)
        {
            parent[parentB] = parentA;
        }
        else
        {
            parent[parentB] = parentA;
            rank[parentA]++;
        }

        return true;
    }

    public int checkAllParents()
    {
        int parentFirst = findParent(0);

        HashSet<Integer> parents = new HashSet<>();
        parents.add(parentFirst);

        int count = 1;
        for(int i = 1; i < n; i++)
        {
            int p = findParent(i);
            if(!parents.contains(p))
            {
                parents.add(p);
                count++;
            }
                
        }
        return count;
    }
}