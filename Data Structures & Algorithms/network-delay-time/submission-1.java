class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        //converting times to graph
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < times.length; i++)
        {
            int[] curr = times[i];
            int s = curr[0] -1, t = curr[1] - 1, w = curr[2];
            graph.get(s).add(new int[]{t, w});
        }

        int[] distance = findDistanceFromSrc(graph, k-1, n);
        int cost = 1;

        for(int d : distance)
        {
            if(d == Integer.MAX_VALUE)
                return -1;
            cost = Math.max(cost,d);
            System.out.println(" cost = " + cost + " d = " + d);
        }
        return cost;
    }

    public static int[] findDistanceFromSrc(ArrayList<ArrayList<int[]>> graph, int src, int n)
    {
        int[] distance = new int[n];

        for(int i = 0; i < n; i++)
            distance[i] =  Integer.MAX_VALUE;
        distance[src] = 0;

        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((ArrayList<Integer> a, ArrayList<Integer> b) -> {
                                                                    int pathA = a.get(1);
                                                                    int pathB = b.get(1);
                                                                    return pathA - pathB;
                                                                   });

        pq.add(new ArrayList<>(List.of(src, 0)));

        HashSet<Integer> hs = new HashSet<>();

        while(pq.size() > 0)
        {
            ArrayList<Integer> curr = pq.remove();
            int currNode = curr.get(0);
            int currPathWt = curr.get(1);

            System.out.println(" currNode = " + currNode);

            if(hs.contains(currNode))
                continue;
            
            hs.add(currNode);

            for(int[] child : graph.get(currNode))
            {
                int childNode = child[0];
                int childWt = child[1];

                distance[childNode] = Math.min(distance[childNode], distance[currNode] + childWt);
                pq.add(new ArrayList<>(List.of(childNode, distance[childNode])));
            }
        }

        return distance;
    }
}

