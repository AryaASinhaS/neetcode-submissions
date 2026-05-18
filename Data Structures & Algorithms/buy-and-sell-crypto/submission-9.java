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
        
        int maxProfit = 0, minBuy = Integer.MAX_VALUE;;
        
        for(int i = 0; i < prices.length; i++)
        {
            minBuy = Math.min(minBuy, prices[i]);
            int profit = prices[i] - minBuy;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
