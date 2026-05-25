class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int n : nums)
        {
            pq.add(n);
        }

        int counter = 1;
        while(counter++ < k)
        {
            pq.poll();
        }

        return pq.peek();
    }
}
