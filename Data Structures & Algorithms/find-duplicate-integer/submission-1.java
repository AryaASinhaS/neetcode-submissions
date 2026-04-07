class Solution {
    public int findDuplicate(int[] nums) {

        for(int i = 0; i < nums.length; i++)
        {
            int num = Math.abs(nums[i]);
            //System.out.println(" i = " + i + " num = " + num + " nums[num-1] = " + nums[num-1]);
            if(nums[num-1] < 0)
                return num;
            nums[num-1] = -1 * nums[num-1];
        }
        return 0;
    }
}
