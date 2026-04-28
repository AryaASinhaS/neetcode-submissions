class Solution {

    HashSet<String> visited = new HashSet<>();
    public int maxAreaOfIsland(int[][] grid) 
    {
        int r = grid.length, c = grid[0].length, maxArea = 0;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == 1)
                {
                    String src = i + ":" + j;
                    ArrayList<String> dfsPath = new ArrayList<>();
                    dfsPathTraversal(grid, src, dfsPath);
                    maxArea = Math.max(maxArea, dfsPath.size());
                }
            }
        }
        return maxArea;
    }

    public void dfsPathTraversal(int[][] grid, String src, ArrayList<String> dfsPath)
    {
        Stack<String> st = new Stack<>();

        st.push(src);
        while(st.size() > 0)
        {
            String parent = st.pop();

            if(visited.contains(parent))
                continue;

            visited.add(parent);
            dfsPath.add(parent);

            String parentRow = parent.substring(0, parent.indexOf(":"));
            String parentCol = parent.substring(parent.indexOf(":") + 1);

            int pRow = Integer.parseInt(parentRow);
            int pCol = Integer.parseInt(parentCol);

            for(String child : findChildren(grid, pRow, pCol))
            {
                if(!visited.contains(child))
                    st.push(child);
            }
        }
    }

    public ArrayList<String> findChildren(int[][] grid, int row, int col)
    {
        ArrayList<String> allChildren = new ArrayList<>();

        if(col-1 >= 0 && grid[row][col-1] == 1)
        {
            String childNode = row + ":" + (col-1);
            allChildren.add(childNode);
        }

        if(col+1 < grid[0].length && grid[row][col+1] == 1)
        {
            String childNode = row + ":" + (col+1);
            allChildren.add(childNode);
        }

        if(row-1 >= 0 && grid[row-1][col] == 1)
        {
            String childNode = (row-1) + ":" + col;
            allChildren.add(childNode);
        }

        if(row+1 <  grid.length && grid[row+1][col] == 1)
        {
            String childNode = (row+1) + ":" + col;
            allChildren.add(childNode);
        }
        return allChildren;
    }
}
