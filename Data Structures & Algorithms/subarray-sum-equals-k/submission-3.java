class Solution {
    public int subarraySum(int[] nums, int k) {

        
        int currSum = 0, diff = 0, counter = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        for(int n : nums)
        {
            currSum = currSum + n;
            diff = currSum - k;
            counter = counter + hm.getOrDefault(diff, 0);
            hm.put(currSum, hm.getOrDefault(currSum, 0) + 1);
        }
        return counter;        
    }
}