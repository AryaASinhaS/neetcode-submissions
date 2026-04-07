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
        
        int buy = 0, sell = 1, maxProfit = prices[sell] - prices[buy];

        
        while(sell < len && buy < sell)
        {
            int profit = prices[sell] - prices[buy];
            System.out.println("profit = " + profit);
            System.out.println("sell = " + sell);
            System.out.println("buy = " + buy);
            //diff is <= 0; Increament left
            if(profit <= 0)
            {
                buy++;
                if(buy == sell)
                    sell++;
            }
            else
            {
                maxProfit = Math.max(maxProfit, prices[sell++] - prices[buy]);
            }

        }
        return (maxProfit > 0 ? maxProfit : 0);
    }
}
