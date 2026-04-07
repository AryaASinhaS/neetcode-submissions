class Solution {
    public int findVolume(int startIndex, int endIndex, int startVal, int endVal)
    {
        int width = endIndex - startIndex;
        int hieght = Math.min(startVal, endVal);
        return width * hieght;
    }
    public int maxArea(int[] heights) {

        int len = heights.length;

        if(len == 0)
            return 0;
        
        int startIndex = 0, endIndex = len - 1, maxVolume = 0;

        while(startIndex < endIndex )
        {
            int volume = findVolume(startIndex, endIndex, heights[startIndex], heights[endIndex]);
            maxVolume = (maxVolume < volume ? volume : maxVolume);
            //we increament the smaller hieght index coz if we don't the lower limit will be set to smaller hieght only
            if(heights[startIndex] <= heights[endIndex])
                startIndex++;
            else
                endIndex--;
        }
        return maxVolume;
    }
}
