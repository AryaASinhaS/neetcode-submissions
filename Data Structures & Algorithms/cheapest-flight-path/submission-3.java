class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] f : flights)
        {
            int s = f[0];
            int t = f[1];
            int w = f[2];

            graph.get(s).add(new int[]{t, w});
        }

        return shortestDistance(n, graph, src, dst, k);

    }

    public int shortestDistance(int n, ArrayList<ArrayList<int[]>> graph, int src, int dst, int k)
    {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((ArrayList<Integer> a, ArrayList<Integer> b) -> {
                                                                            int pathA = a.get(1);
                                                                            int pathB = b.get(1);
                                                                            return pathA - pathB;
                                                                   });
        

        int[] path = new int[n];

        for(int i = 0; i < path.length; i++)
            path[i] = Integer.MAX_VALUE;
        
        path[src] = 0;
        pq.add(new ArrayList<>(List.of(src, 0, 0)));

        HashSet<Integer> hs = new HashSet<>();

        while(pq.size() > 0)
        {
            ArrayList<Integer> curr = pq.remove();
            int currNode = curr.get(0);
            int prevWt = curr.get(1);
            int steps = curr.get(2);  

            if(steps > k + 1)
                continue;

            if(currNode == dst && steps <= k + 1)
            {
                return prevWt;
            }
           
            for(int[] child : graph.get(currNode))
            {
                int childNode = child[0];
                int childWt = child[1];
                int childStep = steps + 1;
                
                //path[childNode] = Math.min(path[childNode], path[currNode]+ childWt);
                
                pq.add(new ArrayList<>(List.of(childNode, prevWt + childWt, childStep)));
            }
        }
        return -1;
    }
}
