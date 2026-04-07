class Solution {
    /**
    [1,2,3,4] target = 3, ans = 2,3
    IP : Array
    OP: 1-based array index
    Approach:
    take two indices start and end
    if sum of nums[start] + nums[end] > target; end-- else start++
    **/
    public int[] twoSum(int[] nums, int target) {

        int start = 0, end = nums.length - 1;
        int[] result = new int[2];

        while(start < end)
        {
            if(nums[start] + nums[end] == target)
            {
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
            else if(nums[start] + nums[end] > target)
            {
                end--;
            }
            else
            {
                start++;
            }
        }
        return result;
    }
}
