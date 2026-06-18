class Solution {
    public int rob(int[] nums) 
    {
        int n = nums.length;

        if(n == 1)
            return nums[0];

        int[] moneyCollected = new int[n];

        moneyCollected[0] = nums[0];
        moneyCollected[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++)
        {
            moneyCollected[i] = Math.max((nums[i] + moneyCollected[i-2]), moneyCollected[i-1]);
        }
        return Math.max(moneyCollected[n-1], moneyCollected[n-2]);
    }
}
