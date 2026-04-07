class Solution {
    /**

    IP: Rotated Sorted Integer Array
    OP: Index of target else -1
    Edge Case: Empty Array
    Approach:

    **/
    public int search(int[] ar, int target) {
        int l = 0, r = ar.length - 1, mid = 0;

        
        
        while(l <= r)
        {
            mid = (l+r)/2; //0

            if(ar[mid] == target)
            {
                return mid;
            }
            if (shouldTraverse(ar, mid+1, r, target))
            {
                l = mid+1;
            }
            else if(shouldTraverse(ar, l, mid-1, target))
            {
                r = mid-1;
            }
            else
                break;
        }
        return -1;
    }

    public boolean shouldTraverse(int[] ar, int l, int r, int target)
    {
        if(l>r)
            return false;
        //if sorted
        if(ar[l] <= ar[r])
        {
            return (ar[l] <= target && target <= ar[r]);
        }
        else
        {
            //not sorted
            return (ar[l] > target || ar[r] < target);
        }
    }
}
