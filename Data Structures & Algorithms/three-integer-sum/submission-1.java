class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
        Example: [-4,-1,-1,0,1,2]
        IP: Array
        OP: ArrayList, 3 array value whose sum = 0
        Edge Case: Empty Array //return empty list
        Approach:
        Sort the array
        Traverse each element and then find val = 0 - element, send this val as an input param to other func that finds if the sum of 2 indices == target 
        exist there or not, also any of that indices != element's index.
        **/

        HashSet<ArrayList<Integer>> coveredTriplets = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++)
        {
            int target = 0 - nums[i];
            ArrayList<ArrayList<Integer>> res = twoSum(i, target, nums);
            if(res.size() > 0)
            {
                for(int j = 0; j < res.size(); j++)
                    coveredTriplets.add(res.get(j));
            }
        }

        for (ArrayList<Integer> list : coveredTriplets) {
            result.add(list);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> twoSum(int originalIndex, int target, int[] nums)
    {
        int startIndex = originalIndex + 1;
        int endIndex = nums.length - 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while(startIndex < endIndex)
        {
            if(nums[startIndex] + nums[endIndex] == target)
            {
                if(startIndex == originalIndex)
                    startIndex++;
                else if(endIndex == originalIndex)
                    endIndex--;
                else
                {

                    ArrayList<Integer> r = new ArrayList<>();
                    r.add(nums[startIndex]);
                    r.add(nums[endIndex]);
                    r.add(nums[originalIndex]);
                    res.add(r);
                    startIndex++;
                    endIndex--;
                }
            }
            else if(nums[startIndex] + nums[endIndex] < target)
            {
                startIndex++;
            }
            else
            {
                endIndex--;
            }
        }
        return res;
    }
}
