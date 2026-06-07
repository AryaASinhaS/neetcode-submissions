class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length() -1, counter = 0;

        while(start <= end)
        {
            if(s.charAt(start) == s.charAt(end))
            {
                start++;
                end--;
            }
            else
            {
                if(counter == 1)
                    return false;
                else
                {
                    counter++;
                    if(s.charAt(start+1) == s.charAt(end) && (s.charAt(start) == s.charAt(end-1)))
                    {
                        return checkPalindrome(start+1, end, s) || checkPalindrome(start, end-1, s);
                    }
                    else
                    {
                        if(s.charAt(start+1) == s.charAt(end))
                            start++;
                        else if(s.charAt(start) == s.charAt(end-1))
                            end--;
                        else
                            return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkPalindrome(int start, int end, String s)
    {
        while(start <= end)
        {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}