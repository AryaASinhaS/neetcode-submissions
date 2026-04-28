class Solution {

    ArrayList<String> visited = new ArrayList<>();
    public int numIslands(char[][] grid) 
    {
        int r = grid.length, c = grid[0].length, count = 0;

        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == '1')
                {
                    ArrayList<String> dfsPath = new ArrayList<>();
                    String src = i + ":" + j;
                    dfsPathTraversal(grid, src, dfsPath);

                    if(dfsPath.size() > 0)
                        count++;
                }
            }
        }
        

        return count;
    }

    public void dfsPathTraversal(char[][] grid, String src, ArrayList<String> dfsPath)
    {
        Stack<String> st = new Stack<>();

        if(visited.contains(src))
                return;

        st.push(src);

        while(st.size() > 0)
        {
            String parent = st.pop();
            //System.out.println("parent = " + parent);

            String parentRow = parent.substring(0, parent.indexOf(":"));
            String parentCol = parent.substring(parent.indexOf(':') + 1);

            int pRow = Integer.parseInt(parentRow);
            int pCol = Integer.parseInt(parentCol);

            if(visited.contains(parent))
                continue;
            
            visited.add(parent);
            dfsPath.add(parent);

            //System.out.println("row = " + row + " size = " + graph.get(row).size());
            for(String child : findChild(grid, pRow, pCol))
            {
                String childRow = child.substring(0, child.indexOf(":"));
                String childCol = child.substring(child.indexOf(':') + 1);
                //System.out.println("child = " + child);
                String nextNode = childRow + ":" + childCol;
                st.push(nextNode);
            }
        }
    }

    public ArrayList<String> findChild(char[][] grid, int row, int col)
    {
        ArrayList<String> allChildren = new ArrayList<>();

        if(col-1 >= 0 && grid[row][col-1] == '1')
        {
            String nextNode = row + ":" + (col-1);
            allChildren.add(nextNode);
        }

        if(col+1 < grid[0].length && grid[row][col+1] == '1')
        {
            String nextNode = row + ":" + (col+1);
            allChildren.add(nextNode);
        }

        if(row-1 >= 0 && grid[row-1][col] == '1')
        {
            String nextNode = (row-1) + ":" + col;
            allChildren.add(nextNode);
        }

        if(row+1 < grid.length && grid[row+1][col] == '1')
        {
            String nextNode = (row+1) + ":" + col;
            allChildren.add(nextNode);
        }
            
        return allChildren;
    } 
}
