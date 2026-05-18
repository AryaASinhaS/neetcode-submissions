class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        if(s.length() <= 1)
            return s.length();

        int start = 0, maxLength = Integer.MIN_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            char curr = s.charAt(i);
            if(hm.containsKey(curr))
            {
                while(hm.containsKey(curr))
                {
                    hm.remove(s.charAt(start++));
                }
            }
            hm.put(curr, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
