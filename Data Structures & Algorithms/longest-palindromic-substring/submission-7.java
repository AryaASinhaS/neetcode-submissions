class Solution {
    public String longestPalindrome(String s) 
    {
        int len = s.length();
        String updatedStr = "" + s.charAt(0);
        for(int i = 1; i < len; i++)
        {
            updatedStr = updatedStr + '#' + s.charAt(i);
        }

        String currPalindrome = "", maxPalindrome = "", result = "";
        int pos = 1;

        len = updatedStr.length();
        //System.out.println("updatedStr = " + updatedStr);

        for(int i = 1; i < len; i++)
        {
            pos = 1;
            while((i - pos) >= 0 && (i + pos) < len && updatedStr.charAt(i - pos) == updatedStr.charAt(i + pos))
            {
                
                currPalindrome = updatedStr.substring(i-pos, i+pos+1);
                //System.out.println("currPalindrome = " + currPalindrome);
                if(currPalindrome.charAt(0) != '#' && currPalindrome.length() >= maxPalindrome.length())
                {
                    maxPalindrome = currPalindrome;
                    
                }
                
                pos++;
            }
        }

        //System.out.println("maxPalindrome = " + maxPalindrome);

        for(int i = 0; i < maxPalindrome.length(); i++)
        {
            if(maxPalindrome.charAt(i) != '#')
            {
                result = result + maxPalindrome.charAt(i);
            }
        }

        return (result != "" ? result : "" + s.charAt(0));
    }
}
