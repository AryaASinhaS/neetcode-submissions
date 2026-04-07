class Solution {

    public String encode(List<String> strs) 
    {
        StringBuilder sb = new StringBuilder();
        for(String s : strs)
        {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) 
    {
        List<String> dc = new ArrayList<>();
        int i = 0, j = 0;

        while(i < str.length())
        {
            j = i;
            while(str.charAt(j)!='#')
                j++;
            int length = Integer.parseInt(str.substring(i,j));

            j++;
            dc.add(str.substring(j,j+length));
            i = j + length;
        }
        return dc;
    }
}
