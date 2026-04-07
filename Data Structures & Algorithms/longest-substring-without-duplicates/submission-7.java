class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        IP : String
        OP : Integer, return max length of string with no repitition characters
        Edge Case: Empty String, return 0
        Approach:

        Use hashmap , construct it along the iteration, add character and its index
        If a repitition happens, remove the existing entry of the key, reduce the curLength by key's first occurance's index and proceed
        At each repitition update the maxLength
        **/

        HashMap<Character, Integer> charFreq = new HashMap<>();
        int left = 0, right = 0, maxLength = 1, len = s.length();

        if(len <= 1)
            return len;
        
        charFreq.put(s.charAt(0),1);

        while(right < len)
        {
            //if condition is met, increament right index
            if(isConditionMet(charFreq))
            {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
                if(right < len)
                {
                    char c = s.charAt(right);
                    charFreq.put(c,charFreq.getOrDefault(c,0) + 1);
                }
            }
            else
            {
                char c = s.charAt(left++);
                charFreq.put(c,charFreq.get(c) - 1);
            }

        }

        return maxLength;
    }

    public boolean isConditionMet(HashMap<Character, Integer> charFreq)
    {
        for(Map.Entry<Character, Integer> entry : charFreq.entrySet())
        {
            if(entry.getValue() > 1)
                return false;
        }
        return true;
    }

}
