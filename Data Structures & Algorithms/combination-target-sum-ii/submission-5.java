class Solution {
    
/**
IP: Integer Array, target
OP: List<List<Integer>> showing combinations where sum of each = target
Edge Case: Empty Array
Approach:
At each step we see if we have to choose the given no of array or not
If we choose we reduce the target by that no. and also append the no. to our answer list
If we dont we ignore the no. and answer remains same
**/

public List<List<Integer>> combinationSum2(int[] nums, int target) {
	Arrays.sort(nums);
	return findAllcombinationSum(nums, target, 0);
	
}

public List<List<Integer>> findAllcombinationSum(int[] nums, int target, int index) {

	List<List<Integer>> result = new ArrayList<>();

	if(target == 0)
	{
		result.add(new ArrayList<>());
		return result;
	}

	if(index >= nums.length || target < 0)
	{
		return result;

	}

	//case 1 - considering the element
	List<List<Integer>> val1 = findAllcombinationSum(nums, target - nums[index], index + 1);
	for(List<Integer> curr : val1)
    {
	    curr.add(nums[index]);
        result.add(curr);
    }
    while(index <nums.length - 1 && nums[index] == nums[index + 1])
        index++;

//case 2 - not considering the element
	List<List<Integer>> val2 = findAllcombinationSum(nums, target, index + 1);
    for(List<Integer> curr : val2)
    {
        result.add(curr);
    }

	return result;

	
	
}



}
