class Solution {
    public int characterReplacement(String s, int k) {
        /**
        IP : String, Integer
        OP : Integer, max length of same characters with k replacement
        Edge Case : Empty String, return 0
        **/
        
        int start = 0, maxLen = Integer.MIN_VALUE;
        int[] charFreq = new int[26];

        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            int index = (int)(curr - 'A');
            charFreq[index]++;

            // move right index till condition met
            if(isConditionMet(charFreq, k))
            {
                maxLen = Math.max(maxLen, i - start + 1);
            }
            else
            {
                while(!isConditionMet(charFreq, k))
                {
                    charFreq[s.charAt(start++) - 'A']--;
                }
            }
        }
        return maxLen;
    }

    public boolean isConditionMet(int[] charFreq, int k)
    {
        int maxFreq = 0, sum = 0;

        for(int i = 0; i < 26; i++)
        {
            if(charFreq[i] > 0)
            {
                sum = sum + charFreq[i];
                maxFreq = Math.max(charFreq[i], maxFreq);
            }                
        }
        return (sum - maxFreq <= k);
    }
}
