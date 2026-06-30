class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int minCoins = coinChangeRec(coins, amount);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public int coinChangeRec(int[] coins, int amount) {


        if(amount == 0)
            return 0;
        
        if(amount < 0)
            return -1;

        if(hm.containsKey(amount))
            return hm.get(amount);
        
        int count = Integer.MAX_VALUE;

        for(int i = 0; i < coins.length; i++)
        {
            int c = coinChangeRec(coins, amount-coins[i]);
            if(c >= 0)
                count = Math.min(c + 1, count);
        }

        count  = (count == Integer.MAX_VALUE ? -1 : count);
        hm.put(amount, count);
        return count;
    }
}
