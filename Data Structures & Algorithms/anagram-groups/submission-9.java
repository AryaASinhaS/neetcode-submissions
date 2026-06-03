class Solution {
    public String sortedString(String s)
    {
        char[] ch = s.toCharArray();
        int[] charVal = new int[26];
        String sortedS = "";
        for(char c : ch)
        {
            charVal[c-'a']++;
        }
        for(int i = 0; i < charVal.length; i++)
        {
            sortedS = sortedS + "|" + charVal[i];
        }
        return sortedS;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String s : strs)
        {
            String sortedS = sortedString(s);
            //System.out.println("s = " + s + " sortedS = " + sortedS);
            if(hm.containsKey(sortedS))
            {
                ArrayList<String> curr = hm.get(sortedS);
                curr.add(s);
                hm.put(sortedS, curr);
            }
            else
            {
                ArrayList<String> curr = new ArrayList<>();
                curr.add(s);
                hm.put(sortedS, curr);
            }
        }

        for (Map.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
