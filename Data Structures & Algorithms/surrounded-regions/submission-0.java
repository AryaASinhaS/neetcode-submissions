class Solution {
    public void solve(char[][] board) 
    {
        /**
        Approch : traverse all 0 cells and see if it's child is a border cell
        if no mark all child as X, else it'll be o
        **/

        int rowLength = board.length, colLength = board[0].length;

        for(int row = 0; row < rowLength; row++)
        {
            for(int col = 0; col < colLength; col++)
            {
                if(board[row][col] == 'O')
                    findSorroundings(row, col, board);
            }
        } 
    }

    public void findSorroundings(int row, int col, char[][] board)
    {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        q.offer(new ArrayList<>(List.of(row, col)));

        while(q.size() > 0)
        {
            ArrayList<Integer> currNode = q.remove();
            int currNodeRow = currNode.get(0);
            int currNodeCol = currNode.get(1);

            if(isBorderCell(currNodeRow, currNodeCol, board))
                return;
            
            String key = currNodeRow + "|" + currNodeCol;
            if(visited.contains(key))
                continue;
            
            visited.add(key);
            result.add(currNode);

            ArrayList<ArrayList<Integer>> children = findAllChildren(currNodeRow, currNodeCol, board);
            for(ArrayList<Integer> child : children)
            {
                q.offer(child);
            }
        }

        for(ArrayList<Integer> sorroundingNodes : result)
        {
            int sorroundingNodesRow = sorroundingNodes.get(0);
            int sorroundingNodesCol = sorroundingNodes.get(1);
            board[sorroundingNodesRow][sorroundingNodesCol] = 'X';
        }
    }

    public boolean isBorderCell(int row, int col, char[][] board)
    {
        return (row == 0 || row == board.length-1 || col == 0 || col == board[0].length-1);
    }

    public ArrayList<ArrayList<Integer>> findAllChildren(int row, int col, char[][] board)
    {
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();

        int[][] child = {{row-1, col}, {row+1, col}, {row, col-1}, {row, col+1}};

        for(int[] ch : child)
        {
            int r = ch[0];
            int c = ch[1];

            if(r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'O')
                children.add(new ArrayList<>(List.of(r, c)));
        }
        return children;
    }
}
