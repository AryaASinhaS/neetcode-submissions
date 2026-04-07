class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        /**

        IP: sorted 2 D Matrix
        OP: Boolean, return if target is there or not
        Edge Case: Empty matrix
        Approach:

        Find the lower Bound of the target and use it's index
        Next just target the 1D array of lower bound and find target in that

        **/

        int l = 0, r = matrix.length - 1, mid = 0, lowerBound = 0;

        lowerBound = findLowerBound(matrix, target);
        System.out.println("lowerBound = " + lowerBound);
        r = matrix[lowerBound].length - 1;

        while(l <= r)
        {
            mid = (l+r)/2;

            if(matrix[lowerBound][mid] == target)
            {
                return true;
            }
            else if(matrix[lowerBound][mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return false;
    }

    public int findLowerBound(int[][] matrix, int target)
    {
        int l = 0, r = matrix.length - 1, mid = 0, potentialLB = 0;

        while(l <= r)
        {
            mid = (l + r)/2;

            System.out.println("l = " + l);
            System.out.println("r = " + r);
            System.out.println("mid = " + mid);
            System.out.println("mid val = " + matrix[mid][0]);

            if(matrix[mid][0] == target)
            {
                return mid;
            }
            else if(matrix[mid][0] < target)
            {
                potentialLB = mid;
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return potentialLB;
    }
}
