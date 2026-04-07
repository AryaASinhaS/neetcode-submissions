class Solution {
    /**

    Input - Two Strings, s = "abcxyz", t = "xyzabc"
    Output - Boolean, true
    Edge Case -
        1. Both Strings are empty //return true
        2. One of the string is empty //return false
    Approach/Pseudo Code -
    Convert string to char Array
    Sort the char array
    return comparison of both sorted arrays

    char[] str1 = s1.tocharArray();
    char[] str2 = s2.tocharArray();

    Arrays.sort(str1);
    Arrays.sort(str2);

    return Arrays.equal;s(str1, str2)


    **/
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
        {
            return false;
        }

        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];


        for(int i = 0; i < s.length(); i++)
        {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            sCharCount[sc - 'a']++;
            tCharCount[tc - 'a']++;
        }

        return Arrays.equals(sCharCount,tCharCount);

    }
}
