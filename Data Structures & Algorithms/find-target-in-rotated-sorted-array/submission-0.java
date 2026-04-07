class Solution {
    public int index = -1;
    public int search(int[] nums, int target) {

        int mid = 0,l = 0, r = nums.length-1;

        searchTarget(nums, l, r , target);
        System.out.println(" index = " +index);
        return index;
        
    }

    public void searchTarget(int[] nums, int l, int r, int target) 
    {
        int mid = 0, result = -1;

        while(l <= r)
        {
            mid = (l+r)/2;
            System.out.println(" l = " + l + " nums[l] = " + nums[l]);
            System.out.println(" r = " + r + " nums[r] = " + nums[r]);
            System.out.println(" mid = " + mid + " nums[mid] = " + nums[mid]);
            if(nums[mid] == target)
            {
                index = mid;
                break;
            }
            searchTarget(nums, l, mid-1, target);
            searchTarget(nums, mid+1, r, target);
            break;
        }
    }

}
