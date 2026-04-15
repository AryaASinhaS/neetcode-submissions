class Solution {
    
    public List<List<Integer>> permute(int[] nums) {

        /**
        ip: Integer array
        OP: All permutations of given numbers
        Edge Case: Empty array, non unique no.s
        Approach:
        make rc by reducing the size of array by 1 and appending the no. to the result
        **/

        HashSet<Integer> hs = Arrays.stream(nums)
                             .boxed()
                             .collect(Collectors.toCollection(HashSet::new));

        List<List<Integer>> result = makePermutations(hs);
        
        return result;        
    }

    public List<List<Integer>> makePermutations(HashSet<Integer> hs) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> baseVal = new ArrayList<>(hs);
        if(hs.size() == 1)
        {
            result.add(baseVal);
            return result;
        }

        for(int n : baseVal)
        {

            hs.remove(n);
            List<List<Integer>> currVal = makePermutations(hs);

            for(List<Integer> c : currVal)
            {
                List<Integer> temp = new ArrayList<>(c);
                temp.add(n);
                result.add(temp);
            }
            hs.add(n);
        }
        return result;
    }
}
