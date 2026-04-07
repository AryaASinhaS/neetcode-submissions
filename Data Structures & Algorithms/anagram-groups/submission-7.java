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
            while(charVal[i] > 0)
            {
                int asciiVal = 97 + i;
                sortedS = sortedS + (char)asciiVal;
                charVal[i]--;
            }
        }
        return sortedS;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
        Input - Array, {"abc","cab","act"}
        Output - ArrayList, {{"abc","cab"},{}"act"}}
        Edge Case - 
            1. Empty Array //return empty List
        Approach/Pseudo Code -

        1. Create a func to return the sorted string of IP String
        2. For each value of IP Array, insert it into a hashmap grouping it by its sorted value
        3. Return all the values of the hashmap

        //func to return sorted string
        String sortedString(String s)
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
                while(charVal[i] > 0)
                {
                    int asciiVal = 97 + i;
                    sortedS = sortedS + (char)asciiVal;
                }
                charVal[i]--;
            }
            return sortedS;
        }

        for(String s : strs)
        {
            String sortedS = sortedString(s);
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
        **/
        
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String s : strs)
        {
            String sortedS = sortedString(s);
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
