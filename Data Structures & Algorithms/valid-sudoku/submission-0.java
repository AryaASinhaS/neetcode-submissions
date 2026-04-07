class Solution {

    /**
    IP : 9*9 matrix of chars
    OP : boolean, isValid or not
    Edge Case : empty matrix //return true
    Approach:
    1. Check for validity of each row and col
    2. Check for validity of 3*# boxes
    Insert the vals in hashmap and check for repitition


    **/

    public boolean isValidRow(int rowIndex, char[][] board)
    {
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < 9; i++)
        {
            if(hs.contains(board[rowIndex][i]) && board[rowIndex][i] != '.')
            {
                return false;
            }
            hs.add(board[rowIndex][i]);
        }
        return true;
    }
    
    public boolean isValidColumn(int columnIndex, char[][] board)
    {
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < 9; i++)
        {
            if(hs.contains(board[i][columnIndex]) && board[i][columnIndex] != '.')
            {
                return false;
            }
            hs.add(board[i][columnIndex]);
        }
        return true;
    }

    public boolean isValidBox(int rowIndex, int columnIndex, char[][] board)
    {
        HashSet<Character> hs = new HashSet<>();
        for(int i = rowIndex ; i < rowIndex + 3; i++)
        {
            for(int j = columnIndex ; j < columnIndex + 3; j++)
            {
                if(hs.contains(board[i][j]) && board[i][j] != '.')
                    return false;
            hs.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {

        boolean validity;
        
        //checking all rows
        for(int i = 0; i < 9; i++)
        {
            validity = isValidRow(i, board);
            if(validity == false)
            {
                System.out.println("Row Invalid = " + i);
                return validity;
            }
        }

        //checking all cols
        for(int i = 0; i < 9; i++)
        {
            validity = isValidColumn(i, board);
            if(validity == false)
            {
                System.out.println("Col Invalid = " + i);
                return validity;
            }
        }

        //checking all 3*3 boxes

        for(int i = 0 ; i < 9; i = i+3)
        {
            for(int j = 0 ; j < 9; j = j+3)
            {
                validity = isValidBox(i,j,board);
                if(validity == false)
                {
                    System.out.println("Box Invalid = " + i);
                    return validity;
                }
                
            }
        }
        return true;


    }
}
