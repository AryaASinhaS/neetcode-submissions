class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        Sort the array
        Insert all elements to hashset
        for each 2 no. combination, check if difference exists in hashset
        if yes, insert answer to result set
        add a fn. to remove duplicates from result set
        */

        Arrays.sort(nums);
        HashMap<Integer, Integer> hs = new HashMap<>();
        HashSet<String> res = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            hs.put(nums[i], i);
        }

        for(int i = 0; i < nums.length -1; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                int currSum = nums[i] + nums[j];
                int diff = 0 - currSum;
                if(hs.containsKey(diff) && hs.get(diff) != i && hs.get(diff) != j)
                {
                    int[] currRes = new int[3];
                    currRes[0] = diff;
                    currRes[1] = nums[i];
                    currRes[2] = nums[j];
                    Arrays.sort(currRes);

                    String key = makeKey(currRes);
                    if(!res.contains(key))
                    {
                        res.add(key);
                        List<Integer> r = new ArrayList<>();

                        for(int c : currRes)
                        {
                            r.add(c);
                        }

                        result.add(r);
                    }
                }
            }
        }
        return result;
    }

    public String makeKey(int[] currRes)
    {
        return (currRes[0] + "|" + currRes[1] + "|" + currRes[2]);
    }
}
