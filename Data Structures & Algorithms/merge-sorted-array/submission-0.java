class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int first = m-1, second = n-1, last = m + n -1;

        while(second >= 0 && first >= 0)
        {
            if(nums1[first] >= nums2[second])
            {
                nums1[last--] = nums1[first--];
            }
            else
            {
                nums1[last--] = nums2[second--];
            }           
        }
        
        while(first >= 0)
        {
            nums1[last--] = nums1[first--];
        }
        while(second >= 0)
        {
            nums1[last--] = nums2[second--];
        }
    }
}