class Solution {
    public boolean isPalindrome(String s) {
        /**

        IP: String
        OP: Boolean
        Edge Case: Empty String //return true
        Approach:

        start traversing the string from start and end and check if start_char == end_char
        if its not same return false

        int len = s.length();

        for(int i = 0; i < len/2; i++)
        {
            char start_char = s.charAt(i);
            char end_char = s.charAt(len - i - 1);

            if(start_char != end_char)
                return false;
        }
        return true;

        **/
        int len = s.length();
        
        String str = "";

        for(int i = 0; i < len; i++)
        {
            char c = s.charAt(i);
            c = Character.toLowerCase(c);
            if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
                str = str + c;
        }
        len = str.length();

        if(len == 0 || len == 1)
            return true; 


        for(int i = 0; i <= len/2; i++)
        {
            char start_char = str.charAt(i);
            char end_char = str.charAt(len - i - 1);

            if(start_char != end_char)
                return false;
        }
        return true;
        
    }
}
