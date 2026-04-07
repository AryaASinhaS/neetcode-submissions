class Solution {
    public int maxProfit(int[] prices) {
        /**
        IP: Array with prices of each day
        OP: Integer, max Profit
        Edge Case : Empty array; return 0; array length >= 1
        Approach:

        1. Maintain 2 index buy and sell, if next integer < current shift both, else add diff as profit and shift both
        **/

        int len = prices.length;

        if(len <= 1)
            return 0;
        
        int buy = 0, sell = 1, profit = 0, maxProfit = 0;
        while(buy < len-1)
        {
            if(prices[buy] < prices[sell])
            {
                profit = prices[sell] - prices[buy];
                maxProfit = (maxProfit > profit ? maxProfit : profit);
            }
            sell++;
            if(sell == len)
            {
                buy++;
                sell = buy+1;
            }
        }

        return maxProfit;
    }
}
