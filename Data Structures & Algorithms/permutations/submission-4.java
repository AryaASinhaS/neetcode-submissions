class Solution {
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
		for(int n : nums)
			hs.add(n);
		return makePermutations(hs);
    }

	public List<List<Integer>> makePermutations(HashSet<Integer> hs)
	{
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> baseVal = new ArrayList<>(hs);

		if(baseVal.size() == 0)
		{
			return result;
		}
		if(baseVal.size() == 1)
		{
			result.add(baseVal);
			return result;
		}

		for(int n : baseVal)
		{
			hs.remove(n);
			List<List<Integer>> currResult = makePermutations(hs);

			for(List<Integer> c : currResult)
			{
				c.add(n);
				result.add(c);
			}
			hs.add(n);
		}
		return result;
	}
}