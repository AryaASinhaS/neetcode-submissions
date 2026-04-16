class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                char c = board[i][j];
                boolean[][] visited = new boolean[board.length][board[0].length];
                if(c == word.charAt(0))
                {
                    if(findWord(board, word, 0, i, j, visited))
                        return true;
                }
            }
        }
        return false;
    }

    //fn. to find possibility of the word
    public boolean findWord(char[][] board, String word, int index, int r, int c, boolean[][] visited)
    {
        if(index >= word.length())
        {
            return true;
        }

        if(r >= board.length || c >= board[0].length || r < 0 || c < 0)
        {
            return false;
        }

        if(visited[r][c] == true)
        {
            return false;
        }

        if(board[r][c] != word.charAt(index))
        {
            return false;
        }

        visited[r][c] = true;

        boolean leftVal = findWord(board, word, index + 1, r, c - 1, visited);
        boolean rytVal = findWord(board, word, index + 1, r, c + 1, visited);
        boolean topVal = findWord(board, word, index + 1, r - 1, c, visited);
        boolean downVal = findWord(board, word, index + 1, r + 1, c, visited); 

        visited[r][c] = false;

        return (leftVal || rytVal || topVal || downVal);
    }
}
