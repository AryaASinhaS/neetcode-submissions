class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
        IP : Array of nums, frequency number; [1,1,2,2,3], k = 2
        OP : Array of nums whose frequency = f; [1,2]
        Edge Case -
            Empty Array //Assumption is that answer exists
        
        Approach/Pseudo Code -

        Insert all elements to hadshmap and log in itrs frequency

        create an array of size n+1 called freq[] where freq[i] will be the list of elements that have occured i times in nums, 
        the array can max consist of all same elements, hence m ax length of the array can be n, n+1 as nums[i] >= 1

        traverse through the hashmap to fill freq[] array

        start from the end of freq array and maintain a counter for k, print all elements till counter = k

       Code -

        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[k];
        int[] freq = new int[nums.length+1];

        for(int i : nums)
        {
            hm.put(i, hm.getOrDefault(i,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();

            freq[v] = k;
        }

        int counter = k, index = 0;

        for(int i = nums.length; i > 0 && counter > 0; i--)
        {
            if(freq[i] > 0)
            {
                result[index++] = freq[i];
                counter--;
            }
        }
        return result;

        **/

        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[k];
        ArrayList<Integer>[] freq = (ArrayList<Integer>[]) new ArrayList[nums.length+1];

        for(int i : nums)
        {
            hm.put(i, hm.getOrDefault(i,0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if(freq[val] == null)
            {
                freq[val] = new ArrayList<>();
            }
            freq[val].add(key);
            
        }

        int counter = k, index = 0;

        for(int i = nums.length; i > 0 && counter > 0; i--)
        {
            if(freq[i] != null)
            {
                ArrayList<Integer> curr = new ArrayList<>();
                curr = freq[i];
                int cnt = 0;
                while(cnt < curr.size() && counter > 0)
                {
                    result[index] = curr.get(cnt++);
                    index++;
                    counter--;
                }
            }
        }
        return result;
        
    }
}
