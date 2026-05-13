class Solution {
    public int maxProfit(int[] prices) {
        /**
        IP: Array with prices of each day
        OP: Integer, max Profit
        Edge Case : Empty array; return 0; array length >= 1
        Approach:

        Update minmBuy with prices[i] each time prices[i] < minmBuy
        In each iteration calculate profit wrt prices[i] and return maxProfit
        **/

        int len = prices.length;

        if(len <= 1)
            return 0;
        
        int buy = 0, sell = 1, maxProfit = prices[sell] - prices[buy], minBuy = prices[buy];
        
        for(int i = 0; i < len; i++)
        {
            minBuy = Math.min(minBuy, prices[i]);
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, profit);
        }
        return (maxProfit > 0 ? maxProfit : 0);
    }
}
