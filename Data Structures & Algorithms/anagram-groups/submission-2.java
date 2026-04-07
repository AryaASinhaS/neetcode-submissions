class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        HashMap<String,List<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++)
        {
            String curr_str = sortedString(strs[i]);
            if(hm.containsKey(curr_str))
            {
                List<String> ls = hm.get(curr_str);
                ls.add(strs[i]);
                hm.put(curr_str,ls);
            }
            else
            {
                List<String> ls = new ArrayList<>();
                ls.add(strs[i]);
                hm.put(curr_str,ls);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> mapElement: hm.entrySet())
        {
            String key = mapElement.getKey();
            List<String> ls = mapElement.getValue();
            result.add(ls);
        }

        return result;
    }
    //method to sort the given string
    public String sortedString(String str)
    {
        char[] charArray = str.toCharArray(); 
        Arrays.sort(charArray);
        String sortedStr = new String(charArray);
        return sortedStr;
    }
}
