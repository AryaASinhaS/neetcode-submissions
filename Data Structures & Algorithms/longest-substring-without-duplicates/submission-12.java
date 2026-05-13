class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() <= 1)
            return s.length();

        int start = 0, maxLength = 0, currLength = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            if(hm.containsKey(curr))
            {
                currLength = i - start;
                maxLength = Math.max(maxLength, currLength);
                start = Math.max(start, hm.get(curr) + 1);
            }
            hm.put(curr, i);
        }
        currLength = s.length() - start;
        maxLength = Math.max(maxLength, currLength);
        return maxLength;
    }
}
