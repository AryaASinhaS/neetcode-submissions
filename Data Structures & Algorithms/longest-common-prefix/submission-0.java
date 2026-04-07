class Solution {
    public String longestCommonPrefix(String[] strs) {
        //find the word with smallest length
        int min = Integer.MAX_VALUE;
        String smallest = "", s = "";

        Arrays.sort(strs);
        min = strs[0].length();
        smallest = strs[0];

        for(int i = smallest.length(); i >= 0; i--)
        {
            s = smallest.substring(0,i);
            boolean indc = true;
            for(int j = 0; j < strs.length; j++)
            {
                if(strs[j].indexOf(s) != 0)
                {
                    indc = false;
                    break;
                }

            }
            if(indc)
            {
                return s;
            }
        }
        return "";
    }
}