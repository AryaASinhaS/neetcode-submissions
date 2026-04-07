class Solution {
    /**

    IP: Rotated Sorted Integer Array
    OP: Index of target else -1
    Edge Case: Empty Array
    Approach:

    **/
    public int search(int[] ar, int target) {
        int l = 0, r = ar.length - 1, mid = 0;

        
        
        while(l <= r)
        {
            mid = (l+r)/2; //0

            if(ar[mid] == target)
            {
                return mid;
            }
            if(ar[mid] < ar[r])
            {
                //RHS is sorted
                if(mid + 1 <= r && ar[mid+1] <= target && target <= ar[r])
                {
                    //no. is on RHS
                    l = mid+1;
                }
                else
                {
                    //no. is in LHS
                    r = mid - 1;
                }
            }
            else
            {
                //LHS is sorted
                if(ar[l] <= target && mid - 1 >= 0 && target <= ar[mid-1])
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
}
