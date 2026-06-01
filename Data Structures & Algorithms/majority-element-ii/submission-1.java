class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int n : nums)
        {
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }

        hm.forEach(
            (key, value) ->
            {
                if(value > (nums.length/3))
                {
                    result.add(key);
                }
            }
        );
        return result;
    }
}