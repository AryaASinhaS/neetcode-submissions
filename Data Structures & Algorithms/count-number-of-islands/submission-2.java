class Solution {

    public int numIslands(char[][] grid) 
    {
        /**
        IP: 2D matrix of char type
        OP: Integer - no. of islands
        Edge Case : empty matrix - return 0
        Approach :
        iterate over all cells in the matrix
        if any cell is '1' then do bfs on that cell,
        in bfs fn. mark the cells being visited as visited = true in another 2d boolean matrix
        each tym the bfs fn return an arraylist of size > 1 increament the counter
        **/

        int row = grid.length, col = grid[0].length, counter = 0;
        boolean[][] visited = new boolean[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == false)
                {
                    counter++;
                    includeConnectedCells(grid, visited, i, j);
                }
            }
        }
        return counter;
    }

    public void includeConnectedCells(char[][] grid, boolean[][] visited, int r, int c)
    {
        Queue<ArrayList<Integer>> bfs = new LinkedList<>();
        bfs.add(new ArrayList<>(List.of(r, c)));

        while(bfs.size() > 0)
        {
            ArrayList<Integer> parent = bfs.poll();

            //marking parent as visited
            int parentRow = parent.get(0);
            int parentCol = parent.get(1);
            if(visited[parentRow][parentCol] == false)
            {
                //get all child of parent that are 1
                ArrayList<ArrayList<Integer>> child = getAllChildren(grid, parentRow, parentCol);

                for(ArrayList<Integer> ch : child)
                {
                    bfs.add(ch);
                }
            }
            visited[parentRow][parentCol] = true;            
        }
    }

    public ArrayList<ArrayList<Integer>> getAllChildren(char[][] grid, int r, int cl)
    {
        int[][] allChildren = {{r-1, cl}, {r+1, cl}, {r, cl-1}, {r, cl+1}};
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int[] c : allChildren)
        {
            if(c[0] < grid.length && c[0] >= 0 && c[1] < grid[0].length && c[1] >= 0 && grid[c[0]][c[1]] == '1')
            {
                result.add(new ArrayList<>(List.of(c[0], c[1])));
            }
        }
        return result;
    }
}
