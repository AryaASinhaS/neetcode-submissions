class Solution {
    public int maxProfit(int[] prices) 
    {
        int l = prices.length, maxProfit = 0;
        for(int i = 1; i < l; i++)
        {
            if(prices[i] > prices[i-1])
            {
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}