class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if(n == 1)
            return nums[0];

        int[] moneyCollected = new int[n];

        moneyCollected[0] = nums[0];
        moneyCollected[1] = nums[0];
        for(int i = 2; i < n-1; i++)
        {
            moneyCollected[i] = Math.max((moneyCollected[i-2] + nums[i]), moneyCollected[i-1]);
        }
        int firstHouseInclusionMoney = moneyCollected[n-2];

        moneyCollected[0] = 0;
        moneyCollected[1] = nums[1];
        for(int i = 2; i < n; i++)
        {
            moneyCollected[i] = Math.max((moneyCollected[i-2] + nums[i]), moneyCollected[i-1]);
        }

        return Math.max(firstHouseInclusionMoney, moneyCollected[n-1]);
    }
}
