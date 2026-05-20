class Solution {
    public List<Integer> findClosestElements(int[] ar, int k, int x) {
        /**
        IP: Sorted array, int k - count, int x - target
        OP: list of k closest integers of x
        Edge case: empty array
        Approach:
        use BS to find LB of x
        move 1 position left and right of LB and pick the numbers which are closer to x
        **/
        List<Integer> result = new ArrayList<>();

        if(ar.length == 0)
            return result;
        int lowerBound = findLowerBound(ar, x), left = lowerBound, right = left+1, count = 0;

        while(count < k && left >= 0 && right < ar.length)
        {
            if(Math.abs(x-ar[left]) <= Math.abs(x-ar[right]))
            {
                result.add(0, ar[left]);
                left--;
            }
            else
            {
                result.add(ar[right]);
                right++;
            }
            count++;
        }

        while(count < k && right == ar.length)
        {
            result.add(0, ar[left]);
            left--;
            count++;
        }

        while(count < k && left < 0)
        {
            result.add(ar[right]);
            right++;
            count++;
        }
        return result;
    }

    public int findLowerBound(int[] ar, int target)
    {
        int l = 0, r = ar.length-1, mid = 0, potentialLB = 0;

        while(l<=r)
        {
            mid = (l+r)/2;
            if(ar[mid] == target)
                return mid;
            else if(ar[mid] < target)
            {
                potentialLB = mid;
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }
        return potentialLB;
    }
}