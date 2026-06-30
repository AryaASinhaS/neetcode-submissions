class Solution {
    public boolean divideArray(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int n : nums)
        {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        for(int v : hm.values())
        {
            if(v%2 != 0)
                return false;
        }
        return true;
    }
}