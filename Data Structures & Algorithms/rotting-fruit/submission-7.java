class Solution {
    public int orangesRotting(int[][] grid) {

        int rowLength = grid.length, colLength = grid[0].length, minTimeTaken = Integer.MAX_VALUE, count = -1;       
        int[][] time = new int[rowLength][colLength];

        for (int[] row : time) {
            Arrays.fill(row, minTimeTaken);
        }

        for(int row = 0; row < rowLength; row++)
        {
            for(int col = 0; col < colLength; col++)
            {
                if(grid[row][col] == 2)
                {
                    HashSet<String> visited = new HashSet<>();
                    int currTimeTaken = computeMinTimeTaken(grid, row, col, visited, time);
                    minTimeTaken = Math.max(minTimeTaken, currTimeTaken);
                }
            }
        }

        for(int row = 0; row < rowLength; row++)
        {
            for(int col = 0; col < colLength; col++)
            {
                if(grid[row][col] != 0)
                {
                    count = Math.max(count, time[row][col]);
                }
            }
        }

        if(count == -1)
            count = 0;
        if(count == Integer.MAX_VALUE)
            count = -1;

        return count;
    }

    public int computeMinTimeTaken(int[][] grid, int row, int col, HashSet<String> visited, int[][] time)
    {
        int currTimeTaken = 0;

        Queue<ArrayList<Integer>> q = new LinkedList<>();

        q.offer(new ArrayList<>(List.of(row, col, 0)));

        while(q.size() > 0)
        {
            ArrayList<Integer> currNode = q.remove();
            int currNodeRow = currNode.get(0);
            int currNodeCol = currNode.get(1);
            int currNodeLvl = currNode.get(2);

            String key = currNodeRow + "|" + currNodeCol;

            if(visited.contains(key) || time[currNodeRow][currNodeCol] < currNodeLvl)
                continue;
            
            visited.add(key);

            time[currNodeRow][currNodeCol] = Math.min(time[currNodeRow][currNodeCol], currNodeLvl);

            currTimeTaken = Math.max(currTimeTaken, time[currNodeRow][currNodeCol]);

            ArrayList<ArrayList<Integer>> allChildren = findAllChildren(grid, currNodeRow, currNodeCol);

            for(ArrayList<Integer> child: allChildren)
            {
                int childRow = child.get(0);
                int childCol = child.get(1);
                q.offer(new ArrayList<>(List.of(childRow, childCol, currNodeLvl + 1)));
            }
        }
        return currTimeTaken;
    }

    public ArrayList<ArrayList<Integer>> findAllChildren(int[][] grid, int row, int col)
    {
        ArrayList<ArrayList<Integer>> allChildren = new ArrayList<>();

        int[][] children = {{row-1, col} , {row+1, col}, {row, col-1}, {row, col+1}};

        for(int[] child : children)
        {
            int r = child[0];
            int c = child[1];

            if((r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
                && (grid[r][c] != 0)
              )
            {
                allChildren.add(new ArrayList<>(List.of(r, c)));
            }
        }
        return allChildren;
    }
}
