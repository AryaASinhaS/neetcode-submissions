class Solution {
    public boolean hasDuplicate(int[] nums) {
        /*
        Input - Array, [10,20,30,10]
        Output - Boolean, true
        Edge Case -
            1. Empty Array: Input - [], Output - false
        Approach / Pseudo Code -
            Traverse the array and while traversing insert array elements to a hashmap.
            Paralelly keep checking if the current elemnet is already inserted in the hashmap or not
            If Yes - return true
            If No - Go ahead and insert the element in the hashmap and continue;
            Once all elements are traversed return false.
        
        for(int i : ar)
        {
            if(hashmap.contains(i))
                return true;
            hashmap.add(i);
        }
        return false;
        */

        HashSet<Integer> hm = new HashSet<>();

        for(int i : nums)
        {
            if(hm.contains(i))
                return true;
            hm.add(i);
        }
        return false;
    }
}