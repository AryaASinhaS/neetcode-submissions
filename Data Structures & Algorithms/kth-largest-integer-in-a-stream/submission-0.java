class KthLargest {

    /**
        IP: integer k, initial array
        OP: kth largest element
        Edge Case: k > pq's size, no elements in array
        Approach:

        create a pq of size k and push 1st k elements of array to it
        next element onwards if pq.peek() > val then push it else no
        we are just concerned with last k elements hence we will push only when we encounter a bigger no.
    **/

    PriorityQueue<Integer> pq;
    int kNum = 0;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        kNum = k;

        for(int j = 0; j < nums.length; j++)
        {
            add(nums[j]);
        }
    }
    
    public int add(int val) {
        
        if(pq.size() < kNum)
        {
            pq.add(val);
        }
        else
        {
            if(pq.peek() < val)
            {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
