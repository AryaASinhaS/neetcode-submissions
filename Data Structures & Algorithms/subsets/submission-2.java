class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
		List<List<Integer>> result = new ArrayList<>();

		result.add(new ArrayList<>());

		for(int n : nums)
		{
			List<List<Integer>> currList = new ArrayList<>();
			for(List<Integer> r : result)
			{
				List<Integer> curr = new ArrayList<>(r);
				curr.add(n);
				currList.add(curr);
			}
			for(List<Integer> c : currList)
			{
				List<Integer> curr = new ArrayList<>(c);
				result.add(curr);
			}
		}
		return result;
    }
}
