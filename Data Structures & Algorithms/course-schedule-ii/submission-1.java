class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for(int[] connections : prerequisites)
        {
            int a = connections[0];
            int b = connections[1];

            inDegrees[a]++;
            graph.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegrees.length; i++)
        {
            if(inDegrees[i] == 0)
                q.add(i);
        }

        result = kahnsBFSAlgorithm(graph, q, inDegrees);
        res = result.stream().mapToInt(i -> i).toArray();

        if(result.size() < numCourses)
            return new int[0];

        return res;

    }

    public  ArrayList<Integer> kahnsBFSAlgorithm(ArrayList<ArrayList<Integer>> graph, Queue<Integer> q, int[] inDegrees)
    {
        ArrayList<Integer> result = new ArrayList<>();

        while(q.size() > 0)
        {
            int node = q.remove();
            result.add(node);

            for(int child : graph.get(node))
            {
                inDegrees[child]--;

                if(inDegrees[child] == 0)
                {
                    q.add(child);
                }
            }
        }
        return result;
    }
}
