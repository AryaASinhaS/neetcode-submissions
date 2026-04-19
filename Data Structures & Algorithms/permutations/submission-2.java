class Solution {
    
    /**
IP: Integer Array
OP: Permutations of the array
Edge Case: Empty Array
Approach:
Fix the array number as first digit and permute over remaining array elements
Base case - no elements left to permute - return empty list
**/
public List<List<Integer>> permute(int[] nums) {


	HashSet<Integer> hs = new HashSet<>();
	for(int n : nums)
	{
		hs.add(n);
	}
	return makePermutations(hs);
	
}
public List<List<Integer>> makePermutations(HashSet<Integer> hs) {


	List<List<Integer>> result = new ArrayList<>();
	List<Integer> baseVal = new ArrayList<>(hs);




	if(hs.size() == 1)
	{
		result.add(baseVal);
		return result;
	}


	if(hs.size() == 0)
	{
		return result;
	}




	for(int n : baseVal)
	{


		hs.remove(n);
		List<List<Integer>> currResult = makePermutations(hs);
		for(List<Integer> currVal : currResult)
		{
			currVal.add(n);
		}


		for(List<Integer> currVal : currResult)
		{
			result.add(currVal);
		}
		hs.add(n);
	}
	return result;


}



}
