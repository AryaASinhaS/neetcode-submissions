class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) 
            return 0;

        HashSet<Integer> allNums = new HashSet<>();
        HashSet<Integer> covered = new HashSet<>();
        int curLen = 1, maxLen = 1;

        for(int i : nums)
        {
            allNums.add(i);
        }

        for(int i = 0; i < nums.length; i++)
        {
            int curr = nums[i];
            if(allNums.contains(curr+1) && !covered.contains(curr))
            {
                while(allNums.contains(curr+1))
                {
                    curLen++;
                    covered.add(curr++);
                }
            }
            maxLen = (curLen > maxLen ? curLen : maxLen);
            curLen = 1;
        }
        return maxLen;
    }
}
