class Solution {
    public HashMap<Integer, Integer> hm = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) 
    {
        int l = cost.length;
       return Math.min(dpFunc(cost, l - 1), dpFunc(cost, l - 2));
    }

    public int dpFunc(int[] cost, int index) {
        if (index < 0) {
            return 0;
        }

        if (hm.containsKey(index)) {
            return hm.get(index);
        }

        int ans = Math.min(dpFunc(cost, index - 1), dpFunc(cost, index - 2)) + cost[index];
        hm.put(index, ans);
        return ans;
    }
}
