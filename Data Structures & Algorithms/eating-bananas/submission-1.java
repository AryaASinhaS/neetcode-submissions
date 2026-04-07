class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /**
        IP: Integer array having pile size, hours
        OP: Min Rate
        Edge Case: Hours is 0, empty array, array val = 0
        Approach:

        Assume a range where rate can be minimum as 1 and max as the maximum value in the array
        Apply BS on this range
        Calculate time keeping in mind rate of eating is mid val of this range
        if(time > hours)
            then we need to increase our rate and traverse to RHS of the range
        else
            we will assume this rate as our LB and search on LHS of range to find lower rate
        **/

        Arrays.sort(piles); //sorting the array to find max val for r

        int l = 1, r = piles[piles.length - 1], mid = 0, time = 0, potentialLB = 0;

        while(l <= r)
        {
            mid = (l+r)/2;
            time = calcTotalTime(piles, mid);

            if(time > h)
            {
                //we should increase rate
                l = mid + 1;
            }
            else
            {
                potentialLB = mid;
                r = mid - 1;
            }
        }
        return  potentialLB;
        
    }

    public int calcTotalTime(int[] ar, int rate)
    {
        int time = 0;

        for(int i = 0; i < ar.length; i++)
        {
            double t = Math.ceil((double)ar[i]/rate);
            time = time + (int)t;
        }
        return time;
    }
}
