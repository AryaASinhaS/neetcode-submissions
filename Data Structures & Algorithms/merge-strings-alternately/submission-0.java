class Solution {
    public String mergeAlternately(String word1, String word2) {

        String result = "";
        int minLen = Math.min(word1.length(), word2.length()), i = 0;

        for(i = 0; i < minLen; i++)
        {
            result = result + word1.charAt(i) + word2.charAt(i);
        }

        if(word1.length() == minLen)
        {
            result = result + word2.substring(i);
        }
        else
        {
            result = result + word1.substring(i);
        }
        return result;
    }
}