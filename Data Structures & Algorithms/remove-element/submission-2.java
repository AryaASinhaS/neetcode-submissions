class Solution {
    public int removeElement(int[] nums, int val) {
        
        int start = 0, count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[start] != val)
            {
                start++;
                count++;
                continue;
            }
            if(nums[i] == val)
            {
                continue;
            }
            else
            {
                count++;
                nums[start] = nums[i];
                nums[i] = val;
                start++;
            }
        }
        return count;
    }
}