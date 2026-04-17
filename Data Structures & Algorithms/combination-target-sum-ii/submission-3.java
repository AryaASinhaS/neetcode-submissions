class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> combinationList = combinationGroups(nums, 0, target);
        return (combinationList);
    }

    public List<List<Integer>> combinationGroups(int[] nums, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(target == 0)
        {
            result.add(new ArrayList<Integer>());
            return result;
        }

        if(index >= nums.length || target < 0)
        {
            return result;
        }

        List<List<Integer>> val1 = new ArrayList<>();
        List<List<Integer>> val2 = new ArrayList<>();

        //Case 1 : Current Index is considered, we make RC on i
        //(same number can be reconsidered) with target = target - nums[i]
        val1 = combinationGroups(nums, index + 1, target - nums[index]);

        //Case 2 : Current Index is not considered, we make RC on i + 1
        //with target = target
        while(index < nums.length-1 && nums[index] == nums[index+1])
            index++;
        val2 = combinationGroups(nums, index + 1, target);

        for(List<Integer> curr : val1)
        {
            curr.add(nums[index]);
            result.add(curr);
        }

        for(List<Integer> curr : val2)
        {
            result.add(curr);
        }

        return result;
    }

}
