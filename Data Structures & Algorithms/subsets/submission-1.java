class Solution {
    /**
IP: Integer Array
OP: List<List<Integer>> of all subsets
Edge Case: Empty Array
Approach:
Start with an arraylist with an empty list, now for each number, iterate the result arraylist and concatenate the numbers in the IP Array with the result lists and return back final result
**/

    public List<List<Integer>> subsets(int[] nums) 
    {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> empty = new ArrayList<>();
    	result.add(empty);

    	//code to get all subsets
    	for(int n : nums)
        {
        	List<List<Integer>> currResult = new ArrayList<>();
        
        	for(List<Integer> curr : result)
        	{
        		List<Integer> temp = new ArrayList<>(curr);
        		temp.add(n);
        		currResult .add(temp);
        	}
        
        	for(List<Integer> curr : currResult )
        	{
        		result .add(curr);
        	}
        }
    	return result;

    }

}
