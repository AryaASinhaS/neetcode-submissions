class Solution {
    public int findKthLargest(int[] nums, int k) {

        /**
        IP: Integer array, number k
        OP: Return k th Largest element
        Edge Case: K > array size, empty array
        Approach:

        Implement a max PQ , if PQ size  >  k , 
        poll and insert the array element only if peek() > arry element
        return peek()
        **/
        
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for(int n : nums)
        {
            if(minPQ.size() < k)
                minPQ.add(n);
            else
            {
                int val = minPQ.peek();
                if(val < n)
                {
                    minPQ.poll();
                    minPQ.add(n);
                }
            }
        }
        return minPQ.peek();
    }
}
