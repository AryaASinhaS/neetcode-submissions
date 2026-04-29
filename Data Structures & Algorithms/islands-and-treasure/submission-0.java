class Solution {
    int minCount = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {

        /**
        IP: Integer 2D array
        OP: Return back the modified array
        Edge Case: Empty array
        Approach: for each cell with 0 value, 
                  do the BFS and update the grid's value with level
        **/
        
        int rowLength = grid.length, columnLength = grid[0].length;

        for(int row = 0; row < rowLength; row++)
        {
            for(int column = 0; column < columnLength; column++)
            {
                if(grid[row][column] == 0)
                {
                    HashSet<String> visited = new HashSet<>();
                    findNearestTreasureBFS(grid, row, column, visited);
                }
            }
        }
    }

    public void findNearestTreasureBFS(int[][] grid, int row, int col, HashSet<String> visited)
    {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.offer(new ArrayList<Integer>(List.of(row, col, 0)));
        
        //iterating thr all child nodes
        while(q.size() > 0)
        {
            ArrayList<Integer> node = q.poll();
            int currRow = node.get(0);
            int currCol = node.get(1);
            int currLevel = node.get(2);
            String key = makeKey(currRow, currCol);

            if (visited.contains(key)) {
                continue;
            }
            visited.add(key);

            //setting grid value
            grid[currRow][currCol] = Math.min(grid[currRow][currCol], currLevel);

            ArrayList<ArrayList<Integer>> children = findAllChildren(grid, currRow, currCol);
            for(ArrayList<Integer> child : children)
            {
                int rowChild   = child.get(0);
                int colChild   = child.get(1);
                int levelChild = currLevel + 1;
                q.offer(new ArrayList<Integer>(List.of(rowChild, colChild, levelChild)));
            }
        }
    }

    public String makeKey(int row, int column) {
        return row + "|" + column;
    }

    public ArrayList<ArrayList<Integer>> findAllChildren(int[][] grid, int row, int col)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int[][] childs = {
            {row - 1 , col},
            {row + 1, col},
            {row, col - 1},
            {row, col + 1}
        };

        for (int[] child : childs) {
            int childRow = child[0];
            int childCol = child[1];
            if (
                (childRow >= 0 && childRow < grid.length) &&
                (childCol >= 0 && childCol < grid[0].length) &&
                grid[childRow][childCol] > 0
            ) {
                result.add(new ArrayList<Integer>(List.of(childRow, childCol)));
            }
        }

        return result;
    }
}
