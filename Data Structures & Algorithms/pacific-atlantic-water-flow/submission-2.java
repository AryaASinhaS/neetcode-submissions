class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        /**
        Approach:
        Make matrix to mark cells from where water can go to pacific and same for atlantic
        by keeping the border cells as parents and treating the neighbouring cells with more hieght 
        traverse both resultant matrix and return answer
        **/

        List<List<Integer>> result = new ArrayList<>();
        int rowLength = heights.length, colLength = heights[0].length;

        int[][] pacific = new int[rowLength][colLength];
        int[][] atlantic = new int[rowLength][colLength];

        //marking parents for pacific
        Arrays.fill(pacific[0], 1);
        for(int row = 0; row < rowLength; row++)
        {
            pacific[row][0] = 1;
        }

        //marking parents for atlantic
        Arrays.fill(atlantic[rowLength-1], 1);
        for(int row = 0; row < rowLength; row++)
        {
            atlantic[row][colLength-1] = 1;
        }

        //mark all cells where water can flow to pacific
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        //push parents to queue
        for(int col = 0; col < pacific[0].length; col++)
            q.offer(new ArrayList<>(List.of(0, col)));
        for(int row = 0; row < pacific.length; row++)
            q.offer(new ArrayList<>(List.of(row, 0)));
        findOceanFlowingCells(q, "Pacific", heights, pacific, atlantic);

        //mark all cells where water can flow to atlantic
        q.clear();

        //push parents to queue
        for(int col = 0; col < atlantic[0].length; col++)
            q.offer(new ArrayList<>(List.of(rowLength-1, col)));
        for(int row = 0; row < atlantic.length; row++)
            q.offer(new ArrayList<>(List.of(row, colLength-1)));
        findOceanFlowingCells(q, "Atlantic", heights, pacific, atlantic);

        for(int i = 0; i < rowLength; i++)
        {
            for(int j = 0; j < colLength; j++)
            {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1)
                {
                    result.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return result;
    }

    //mark all cells where water can flow to pacific
    public void findOceanFlowingCells(Queue<ArrayList<Integer>> q, String ocean, int[][] heights,
                                     int[][] pacific, int[][] atlantic)
    {
        
        HashSet<String> visited = new HashSet<>();

        while(q.size() > 0)
        {
            ArrayList<Integer> currNode = q.remove();
            int currNodeRow = currNode.get(0);
            int currNodeCol = currNode.get(1);
            String key = currNodeRow + "|" + currNodeCol;

            if(visited.contains(key))
                continue;
            
            visited.add(key);

            //marking the node
            if(ocean == "Pacific")
                pacific[currNodeRow][currNodeCol] = 1;
            else
                atlantic[currNodeRow][currNodeCol] = 1;

            ArrayList<ArrayList<Integer>> children = findAllChildren(currNodeRow, currNodeCol, heights);
            for(ArrayList<Integer> child : children)
            {
                q.offer(child);
            }
        }
    }

    //fn. to find all children of current Node
    public ArrayList<ArrayList<Integer>> findAllChildren(int row, int col, int[][] ar)
    {
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();

        int[][] child = {{row-1, col}, {row+1, col}, {row, col-1}, {row, col+1}};

        for(int[] ch : child)
        {
            int r = ch[0], c = ch[1];
            if(r >= 0 && r < ar.length && c >= 0 && c < ar[0].length && ar[r][c] >= ar[row][col])
                children.add(new ArrayList<>(List.of(r, c)));
        }

        return children;
    }
}
