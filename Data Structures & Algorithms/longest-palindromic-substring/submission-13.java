class Solution {
    public String longestPalindrome(String s) 
    {
        int len = s.length();
        String updatedStr = "" + s.charAt(0), res = "", palindromeStr = "";
        for(int i = 1; i < len; i++)
        {
            updatedStr = updatedStr + '#' + s.charAt(i);
        }

        int currPalindrome = 0, maxPalindrome = 0;
        int[] result = new int[2];
        int pos = 1;

        len = updatedStr.length();

        for(int i = 1; i < len; i++)
        {
            pos = 1;
            while((i - pos) >= 0 && (i + pos) < len && updatedStr.charAt(i - pos) == updatedStr.charAt(i + pos))
            {   
                pos++;
            }

            pos--;
            currPalindrome = 2*pos;
              
            if(currPalindrome > maxPalindrome || (updatedStr.charAt(i-pos) != '#' && currPalindrome == maxPalindrome))
            {
                maxPalindrome = currPalindrome;
                result[0] = i-pos;
                result[1] = i+pos;
            }   
        }

        //System.out.println("result[0] = " + result[0]);
        //System.out.println("result[1] = " + result[1]);

        palindromeStr = updatedStr.substring(result[0], result[1]+1);
        //System.out.println("palindromeStr = " + palindromeStr);

        for(int i = 0; i < palindromeStr.length(); i++)
        {
            if(palindromeStr.charAt(i) != '#')
            {
                res = res + palindromeStr.charAt(i);
            }
        }

        return (res != "" ? res : "" + s.charAt(0));
    }
}
