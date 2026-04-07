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

        HashMap<Character, Integer> charPosition = new HashMap<>();
        int start = 0, end = 1, maxLength = 1, length = 1, strLength = s.length();

        if(strLength <= 1)
            return strLength;

        for(int i = 0; i < strLength; i++)
        {
            char c = s.charAt(i);
            if(charPosition.containsKey(c))
            {
                int pos = charPosition.get(c);
                start = (pos < start ? start : pos+1);
                //System.out.println(c + " " + pos);
            }
            length = i - start + 1;
            System.out.println("word = " + s.substring(start, start + length));
            maxLength = (maxLength > length ? maxLength : length);
            charPosition.put(c, i);

        }
        return maxLength;
    }
}
