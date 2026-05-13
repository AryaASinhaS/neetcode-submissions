class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() <= 1)
            return s.length();

        int start = 0, maxLength = 0;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            int currLength = i - start;
            maxLength = Math.max(maxLength, currLength);
            if(hm.containsKey(curr))
            {
                start = Math.max(start, hm.get(curr) + 1);
            }
            hm.put(curr, i);
        }
        return Math.max(maxLength, s.length() - start);
    }
}
