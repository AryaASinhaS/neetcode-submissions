class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                // Only check if the cell contains a digit
                if (val != '.') {
                    // Create unique string markers for row, column, and 3x3 box
                    String rowMarker = val + " in row " + r;
                    String colMarker = val + " in col " + c;
                    String boxMarker = val + " in box " + (r / 3) + "-" + (c / 3);

                    // .add() returns false if the string is already in the Set
                    if (!seen.add(rowMarker) || 
                        !seen.add(colMarker) || 
                        !seen.add(boxMarker)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}