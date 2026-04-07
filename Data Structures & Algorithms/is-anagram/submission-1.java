class Solution {
    public boolean isAnagram(String s, String t) 
    {
        String sortS = sortString(s);
        String sortT = sortString(t);

        //System.out.println("sortS = " + sortS + " sortT = " + sortT);

        return sortS.equals(sortT);
    }

    //function to sort a string
    public static String sortString(String str)
    {
        int count[] = new int[26];
        for(char c : str.toCharArray())
        {
            count[c - 'a']++;
        }
        String sortedStr = Arrays.toString(count);
        return sortedStr;
    }
}
