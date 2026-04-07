class Solution {
    /**
    Input - Array, [2,3,6,5]. Integer target = 7
    Output - Array(size - 2) containing indices of numbers whose sum = target, [0,3]
    Edge Case -
        1. Empty I/P Array //Assumption that I/P array contains 2 indices with values whose sum = target
        2. More than one solution //Assumption that only one soln exists

    Approach/Pseudo Code -

        Traverse through I/P Array and insert the elements and it's index to hashmap
        In each iteration check if target - current_val exists in hashmap, if yes return current index and it's counterparts index
    
    for(int i : nums)
    {
        int counterPart = target - nums[i];
        if(hm.contains(counterPart))
        {
            result[0] = hm.get(counterPart);
            result[1] = i;
        }
        hm.put(nums[i], i);
    }
    return result
    **/
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int counterPart = target - nums[i];
            if(hm.containsKey(counterPart))
            {
                result[0] = hm.get(counterPart);
                result[1] = i;
                break;
            }
            hm.put(nums[i], i);
        }
        return result;
    }
}
