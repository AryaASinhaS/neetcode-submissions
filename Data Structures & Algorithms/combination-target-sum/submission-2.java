class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        /**
		Sort the array
		at each iteration, branch into checking 2 scenes, one where we will consider nums[i] again
		another where we wont
		if we reach end of array return back
		**/

		return findAllCombinations(nums, 0, target);
    }

	public List<List<Integer>> findAllCombinations(int[] nums, int startIndex, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(target == 0)
		{
			result.add(new ArrayList<>());
			return result;
		}

		if(startIndex >= nums.length || target < 0)
			return result;
		
		//consider the current nums
		List<List<Integer>> val1 = findAllCombinations(nums, startIndex, target - nums[startIndex]);
		for(List<Integer> curr : val1)
		{
			List<Integer> c = new ArrayList<>(curr);
			c.add(nums[startIndex]);
			result.add(c);
		}

		//do not consider the current nums
		List<List<Integer>> val2 = findAllCombinations(nums, startIndex + 1, target);
		for(List<Integer> curr : val2)
		{
			List<Integer> c = new ArrayList<>(curr);
			result.add(c);
		}
		return result;
	}
}
