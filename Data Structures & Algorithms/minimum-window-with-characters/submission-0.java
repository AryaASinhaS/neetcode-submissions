class Solution {
    public String minWindow(String s, String t) {

        /**
        IP: Two Strings s and t
        OP: return the shortest substring of s such that every character in t, including duplicates, is present in the substring
        Edge case : if either string is empty return "", if s.length() < t.length(), return ""
        Approach : 
        while condition is not met - keep moving right
        once condition is met, keep the substring as potential answer and start dropping characters from left
        **/

        //edge cases
        if(s.length() < t.length())
            return "";
        if(s.length() == 0 || t.length() == 0)
            return "";
        
        int start = 0, end = 0, sLen = s.length(), maxLen = Integer.MAX_VALUE;
        int[] fArrayT = convertToFreqArray(t);
        int[] fArrayS = convertToFreqArray(s.substring(0, 1));
        String minStr = "";

        while(end < sLen)
        {
            if(conatinsPermutation(fArrayT, fArrayS))
            {
                int len = end - start + 1;
                if(len < maxLen)
                {
                    maxLen = len;
                    minStr = (end == sLen - 1 ?  s.substring(start) : s.substring(start, end+1));
                }

                //drop character from left - start
                int index = findCharIndex(s.charAt(start));
                fArrayS[index]--;
                start++;
            }
            else
            {
                end++;
                if(end < sLen)
                {
                    int index = findCharIndex(s.charAt(end));
                    fArrayS[index]++;
                }
            }
        }
        return minStr;
    }

    public int[] convertToFreqArray(String s)
    {
        int[] fArray = new int[52];
        for(int i = 0; i < s.length(); i++)
        {
            int index = findCharIndex(s.charAt(i));
            fArray[index]++;
        }
        return fArray;
    }

    public int findCharIndex(char c)
    {
        if(Character.isUpperCase(c))
        {
            int index = (int)(c - 'A');
            return index + 26;
        }
        int index = (int)(c - 'a');
        return index;
    }

    public boolean conatinsPermutation(int[] arT, int[] arS)
    {
        for(int i = 0; i < 52; i++)
        {
            if(arT[i] > 0 && arS[i] < arT[i])
                return false;
        }
        return true;
    }
}
