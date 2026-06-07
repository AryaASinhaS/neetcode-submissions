class NumMatrix {
    public int[][] prefixSum;

    public NumMatrix(int[][] matrix) 
    {
        int row = matrix.length, col = matrix[0].length;
        prefixSum = new int[row][col];

        for(int r = 0; r < row; r++)
        {
            prefixSum[r][0] = matrix[r][0];
            for(int c =1; c < col; c++)
            {
                prefixSum[r][c] = prefixSum[r][c-1] + matrix[r][c];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) 
    {
        int res = 0;

        for(int r = row1; r <= row2; r++)
        {
            if(col1 > 0)
            {
                res = res + prefixSum[r][col2] - prefixSum[r][col1 - 1];
            }
            else
            {
                res = res + prefixSum[r][col2];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */