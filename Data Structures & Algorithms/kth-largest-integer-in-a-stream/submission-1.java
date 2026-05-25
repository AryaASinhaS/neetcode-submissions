class KthLargest {

    public int k = 0;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i++)
        {
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > k)
            pq.poll();
        return pq.peek();
    }
}
