class Solution {
    public int removeDuplicates(int[] nums) 
    {
        int counter = 0, i = 0;

        while(i < nums.length)
        {
            nums[counter++] = nums[i++];
            while(i < nums.length && nums[i] == nums[i-1])
                i++;
        }
        return counter;
    }
}