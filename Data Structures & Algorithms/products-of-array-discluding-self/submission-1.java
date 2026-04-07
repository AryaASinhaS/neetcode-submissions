class Solution {
    /**
    IP: Array of nums
    OP: Array of nums
    Edge Case : contains 0
    Approach:
    Make 2 arrays , one to store prefix product, another to store postfix product
    result array will be multiplication of both

    **/
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] prefixProduct = new int[len];
        int[] postProduct = new int[len];
        int[] result = new int[len];
        int preProd = 1, postProd = 1;

        for(int i = 0; i < len; i++)
        {
            prefixProduct[i] = preProd * (i == 0 ? 1 : nums[i-1]);
            preProd = prefixProduct[i];
        }

        for(int i = len-1; i >= 0; i--)
        {
            postProduct[i] = postProd * (i == len-1 ? 1 : nums[i+1]);
            postProd = postProduct[i];
        }
        
        for(int i = 0; i < len; i++)
        {
            result[i] = prefixProduct[i] * postProduct[i];
        }
        return result;
    }
}  
