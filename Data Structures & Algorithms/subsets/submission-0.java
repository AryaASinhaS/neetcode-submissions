class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /**
        IP: Integer array
        OP: List of List of all subsets
        Edge Case: Empty array
        Approach:

        feed empty set to result, now for each element add new elements by
        adding current element to the set
        **/

        List<List<Integer>> allSubsets = new ArrayList<>();
        ArrayList<Integer> empty = new ArrayList<>();
        allSubsets.add(empty);


       
       

        for(int n : nums)
        {
            List<List<Integer>> currentSubsets = new ArrayList<>();
            int i =  0;
            while(i < allSubsets.size())
            {
                List<Integer> curr = new ArrayList<>(allSubsets.get(i++));
                curr.add(n);
                currentSubsets.add(curr);
            }
            i =  0;
            while(i < currentSubsets.size())
            {
                List<Integer> curr = currentSubsets.get(i++);
                allSubsets.add(curr);
            }
        }
        return allSubsets;
    }
}
