class Solution {

    public String encode(List<String> strs) 
    {
        if(strs.size() == 0)
            return "";
        String en = strs.get(0);
        for(int i = 1; i < strs.size(); i++)
            en = en + "." + strs.get(i);
        en = en + ".";
        return en;
    }

    public List<String> decode(String str) 
    {
        List<String> dc = new ArrayList<>();
        int start = 0, end = 0;
        String s = "";
        System.out.println("str = " + str);
        for(int i = 0; i < str.length(); i++)
        {
            end = str.indexOf(".", start);
            System.out.println("end = " + end);
            if(end > -1)
                s = str.substring(start,end);
            else
                break;
            System.out.println("s = " + s);
            dc.add(s);
            start = end + 1;
            System.out.println("start = " + start);
        }
        return dc;
    }
}
