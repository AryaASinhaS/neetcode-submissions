class Solution {
    /**
    Edge Case: 
    Either string is empty //assumption both strings are not empty
    s2.length < s1.length // return false
    **/
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length())
            return false;
        
        if(s2.length() == 0 || s1.length() == 0)
            return false;
        
        int[] freqArray1 = new int[26];
        int[] freqArray2 = new int[26];
        int start = 0;

        for(int i = 0; i < s1.length(); i++)
        {
            char curr = s1.charAt(i);
            int index = (int)(curr - 'a');
            freqArray1[index]++;

            curr = s2.charAt(i);
            index = (int)(curr - 'a');
            freqArray2[index]++;
        }

        for(int i = s1.length(); i < s2.length(); i++)
        {
            if(isPermutation(freqArray1, freqArray2))
                return true;
            else
            {
                
                char curr = s2.charAt(start++);
                int index = (int)(curr - 'a');
                freqArray2[index]--;

                curr = s2.charAt(i);
                index = (int)(curr - 'a');
                freqArray2[index]++;
                
            }
        }
        return isPermutation(freqArray1, freqArray2);
    }

    public boolean isPermutation(int[] ar1, int[] ar2)
    {
        for(int i = 0;  i < 26; i++)
        {
            if(ar2[i] != ar1[i])
                return false;
        }
        return true;
    }
}
