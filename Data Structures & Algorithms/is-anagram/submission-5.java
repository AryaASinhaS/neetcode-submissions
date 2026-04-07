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

        if(s == "" && t == "")
        {
            return true;
        }
        if(s.length() != t.length())
        {
            return false;
        }
        
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(st);

        return Arrays.equals(sc,st);

    }
}
