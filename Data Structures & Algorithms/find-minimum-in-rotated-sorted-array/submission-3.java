class Solution {
    public int findMin(int[] nums) {

        /**

        IP: Rotated Sorted Array
        OP: Minimum number in the array

        Edge Case: 
        Non Unique elements //assumption : numbers are unique
        Empty Array //assumption : non empty array

        Approach:

        keep splitting the array into 2 halves and chack for such element where l < ele < r and return it

        **/

        if(nums[0] <= nums[nums.length-1])
            return nums[0];


        return minElementSearch(nums, 0 , nums.length-1);
        
    }

    public int minElementSearch(int[] nums, int l, int r)
    {
        int mid = (l+r)/2;
        while(l <= r)
        {
            //System.out.println(" l = " + l + " nums[l] = " + nums[l]);
            //System.out.println(" r = " + r + " nums[r] = " + nums[r]);
            //System.out.println(" mid = " + mid + " nums[mid] = " + nums[mid]);
            if( mid > 0 && nums[mid] < nums[mid-1] && mid - 1 < r-1 && nums[mid] < nums[mid+1])
            {
                return nums[mid]; //found smallest element
            }
        
            return Math.min(minElementSearch(nums, l, mid-1), minElementSearch(nums, mid+1, r));
        }
        return nums[mid];
    }
}
