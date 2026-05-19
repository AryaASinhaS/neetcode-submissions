class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        /**
        IP: Integer array
        OP: minimum size of array whose sum >= target
        Edge case: entire array sum < target or array size < 1; return 0
        Approach:
        while sub array sum < target - keep adding right elements, else keep dropping left elements
        **/

        int start = 0, end = 0, minLen = Integer.MAX_VALUE, sum = nums[0];

        while(start<=end && end < nums.length)
        {
            if(sum < target)
            {
                end++;
                if(end < nums.length)
                    sum = sum + nums[end];
            }
            else
            {
                minLen = Math.min(minLen, end - start + 1);
                sum = sum - nums[start++];
            }
        }
        return (minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}