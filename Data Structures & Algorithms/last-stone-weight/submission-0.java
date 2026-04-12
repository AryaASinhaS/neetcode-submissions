class Solution {

    /**
    IP: Integer array
    OP: Resukt weight
    Edge Case: empty array
    Approach:

    Design a Max PQ
    In each iteration poll 2 val, push Math.abs(val1-val2)
    Iterate till PQ.size() > 1
    return pq.peek() or 0
    **/
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : stones)
        {
            maxPQ.add(num);
        }

        while(maxPQ.size() > 1)
        {
            int stone1 = maxPQ.poll();
            int stone2 = maxPQ.poll();

            if(stone1 - stone2 != 0)
                maxPQ.add(Math.abs(stone1 - stone2));
        }

        return (maxPQ.size() == 1 ? maxPQ.peek() : 0);
        
    }
}
