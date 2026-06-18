class Solution {
    HashMap<Integer, Integer> hm = new HashMap<>();
    public int rob(int[] nums) 
    {
        return dpFunc(nums, nums.length - 1);
    }

    public int dpFunc(int[] nums, int index)
    {
        if(index == 0)
            return nums[0];
        
        if(index == 1)
            return Math.max(nums[0], nums[1]);
        
        if(hm.containsKey(index))
            return hm.get(index);
            
        int ans = Math.max((nums[index] + dpFunc(nums, index - 2)), dpFunc(nums, index - 1));
        hm.put(index, ans);
        return ans;
    }
}
