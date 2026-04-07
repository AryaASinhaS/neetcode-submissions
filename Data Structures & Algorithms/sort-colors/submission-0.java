class Solution {
    public void sortColors(int[] nums) 
    {
        int c_0 = 0;
        int c_1 = 0;
        int c_2 = 0;

        for(int i = 0; i < nums.length; i++)
        {
            switch(nums[i])
            {
                case 0 : c_0++;break;
                case 1 : c_1++;break;
                case 2 : c_2++;break;
            }
        }

        int c = 0;
        while(c_0 > 0)
        {
            nums[c] = 0;
            c_0--;
            c++;
        }

        while(c_1 > 0)
        {
            nums[c] = 1;
            c_1--;
            c++;
        }

        while(c_2 > 0 && c < nums.length)
        {
            nums[c] = 2;
            c_2--;
            c++;
        }
    }
}