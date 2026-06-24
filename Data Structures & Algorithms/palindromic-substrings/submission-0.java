class Solution {
    public int countSubstrings(String s) {
        
        int len = s.length();
        String updatedStr = "" + s.charAt(0);
        for(int i = 1; i < len; i++)
        {
            updatedStr = updatedStr + '#' + s.charAt(i);
        }

        int pos = 1, count = s.length();

        len = updatedStr.length();

        for(int i = 1; i < len; i++)
        {
            pos = 1;
            while((i - pos) >= 0 && (i + pos) < len && updatedStr.charAt(i - pos) == updatedStr.charAt(i + pos))
            { 
                if(updatedStr.charAt(i-pos) != '#')  
                    count++;
                pos++;
            }
        }

        return count;
    }
}
