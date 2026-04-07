class Solution {
    /**
    Edge Case: 
    Either string is empty //assumption both strings are not empty
    s2.length < s1.length // return false
    **/
    public boolean checkInclusion(String s1, String s2) {
        
        int len1 = s1.length(), len2 = s2.length();

        if(len2 < len1)
            return false;
        
        int startPos = 0;
        
        while(startPos <= len2 - len1)
        {
            String toBeChecked = s2.substring(startPos, startPos + len1);
            //if permutation occurs , return true
            if(isPermutation(s1,toBeChecked))
                return true;
            else
            {
                startPos++;
            }
        }
        return false;
    }

    public boolean isPermutation(String s1, String s2)
    {

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for(int i = 0; i < s1.length(); i++)
        {
            char c1= s1.charAt(i);
            char c2= s2.charAt(i);
            s1Freq[c1 - 'a']++;
            s2Freq[c2 - 'a']++;
        }

        for(int i = 0; i < 26; i++)
        {
            if(s1Freq[i] != s2Freq[i])
                return false;
        }
        return true;
    }
}
