class Solution {
    
    public int maxArea(int[] heights) {

        int maxVolume = 0, left = 0, right = heights.length - 1;

        if(heights.length == 1)
            return 0;
        
        while(left < right)
        {
            int volume = findVolume(heights, left, right);
            maxVolume = Math.max(maxVolume, volume);

            if(heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxVolume;
    }

    public int findVolume(int[] heights, int left, int right)
    {
        return (heights[left] < heights[right] ? heights[left] : heights[right]) * (right - left);
    }
}
