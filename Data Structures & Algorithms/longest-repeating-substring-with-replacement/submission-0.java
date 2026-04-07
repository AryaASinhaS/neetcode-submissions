class Solution {
    public int characterReplacement(String s, int k) {
        /**
        IP : String, Integer
        OP : Integer, max length of same characters with k replacement
        Edge Case : Empty String, return 0
        **/
        
        int left = 0, right = 0, len = s.length(), maxLen = 1;
        int[] charFreq = new int[26];
        charFreq[s.charAt(0) - 'A']++;

        while(right < len)
        {
            // move right index till condition met
            if(isConditionMet(charFreq, k))
            {
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
                if(right < len)
                {
                    charFreq[s.charAt(right) - 'A']++;
                }
            }
            else
            {
                charFreq[s.charAt(left++) - 'A']--;
            }
        }
        return maxLen;
    }

    public boolean isConditionMet(int[] charFreq, int k)
    {
        int maxFreq = 0, sum = 0;

        for(int i = 0; i < 26; i++)
        {
            int freq = charFreq[i];
            sum = sum + freq;
            maxFreq = Math.max(freq, maxFreq);                
        }

        return (sum - maxFreq <= k);

    }
}
