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
        
        int buy = 0, i = 1, profit = 0, maxProfit = 0;
        
        while(i < len)
        {
            if(prices[i] < prices[buy])
            {
                buy = i++;
            }
            else
            {
                profit = prices[i++] - prices[buy];
                maxProfit = (maxProfit > profit ? maxProfit : profit);
            }
        }
 
        return maxProfit;
    }
}
