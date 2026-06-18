class Solution {
    public int minCostClimbingStairs(int[] cost) 
    {
        int n = cost.length;
        int[] costTillIndex = new int[n];

        costTillIndex[0] = cost[0];
        costTillIndex[1] = cost[1];

        for(int i = 2; i < n; i++)
        {
            costTillIndex[i] = Math.min(costTillIndex[i-1], costTillIndex[i-2]) + cost[i];
        }
        
        return Math.min(costTillIndex[n-1], costTillIndex[n-2]);
    }
}
