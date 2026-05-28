class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length, col = grid[0].length, maxIslandCount = 0;
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == false)
                {
                    visited[i][j] = true; 
                    int islandCount = includeConnectedCells(grid, visited, i, j);
                    maxIslandCount = Math.max(maxIslandCount, islandCount);
                }
            }
        }
        return maxIslandCount;
    }

    public int includeConnectedCells(int[][] grid, boolean[][] visited, int r, int c)
    {
        int islandCount = 0;

        Queue<ArrayList<Integer>> bfs = new LinkedList<>();
        bfs.add(new ArrayList<>(List.of(r, c)));

        while(bfs.size() > 0)
        {
            ArrayList<Integer> parent = bfs.poll();

            //marking parent as visited
            int parentRow = parent.get(0);
            int parentCol = parent.get(1);
            
            //get all child of parent that are 1
            ArrayList<ArrayList<Integer>> child = getAllChildren(grid, visited, parentRow, parentCol);

            for(ArrayList<Integer> ch : child)
            {
                bfs.add(ch);
            }

            //System.out.println(islandCount + "parentRow = " + parentRow + " parentCol = "+ parentCol);
            islandCount++;          
        }
                            

        return islandCount;
    }

    public ArrayList<ArrayList<Integer>> getAllChildren(int[][] grid, boolean[][] visited, int r, int cl)
    {
        int[][] allChildren = {{r-1, cl}, {r+1, cl}, {r, cl-1}, {r, cl+1}};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int[] c : allChildren)
        {
            if(c[0] < grid.length && c[0] >= 0 && c[1] < grid[0].length && c[1] >= 0 
            && grid[c[0]][c[1]] == 1 && visited[c[0]][c[1]] == false)
            {
                result.add(new ArrayList<>(List.of(c[0], c[1])));
                visited[c[0]][c[1]] = true; 
            }
        }
        return result;
    }
}
