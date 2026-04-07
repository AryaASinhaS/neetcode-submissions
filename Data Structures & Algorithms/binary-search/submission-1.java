class Solution {
    public int search(int[] nums, int target) {
        
        /**
        IP: Integer sorted array
        OP: Integer, return index if found else -1
        Edge Cases: Empty Array, return -1
        Approach:

        Iterate while left index <= right index
        find mid index
        if target < mid index no, search on LHS else RHS
        If target == mid index no then return the index
        return -1 outside the loop
        **/

        int l = 0, r = nums.length - 1, mid = 0;

        while(l<=r)
        {
            mid = (l+r)/2;

            if(nums[mid] == target)
            {
                return mid;
            }
            else if(nums[mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return -1;
    }
}
