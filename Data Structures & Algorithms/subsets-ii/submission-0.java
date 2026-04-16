class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /**
        IP: Integer Array
        OP: List<List<Integer>> WITH ALL SUBSETS
        Approach:
        start with a list that is empty, then for each next number iterate over results and add current number to each sub lists
        **/

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        result.add(empty);

        for(int n : nums)
        {
            List<List<Integer>> currResult = new ArrayList<>();
            for(List<Integer> curr : result)
            {
                
                    List<Integer> temp = new ArrayList<>(curr);
                    temp.add(n);
                    currResult.add(temp);
                
            }

            //adding modified lists to result
            for(List<Integer> curr : currResult)
            {
                result.add(curr);
            }
        }
        return removeDuplicates(result);
    }

    //fn to make arraylists distinc
    public List<List<Integer>> removeDuplicates(List<List<Integer>> result)
    {
        HashSet<List<Integer>> hs = new HashSet<>(result);
        return new ArrayList<>(hs);
    }
}
