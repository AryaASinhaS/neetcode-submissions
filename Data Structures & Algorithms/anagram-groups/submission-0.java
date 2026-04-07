class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++)
        {
            String word = strs[i];
            int[] freq = new int[26];

            for(int j = 0; j < word.length(); j++)
            {
                char ch = word.charAt(j);
                freq[ch-'a']++;
            }

            String k = Arrays.toString(freq);

            List<String> ls = new ArrayList<>();
            if(hm.containsKey(k))
            {
                ls = hm.get(k);
            }
            ls.add(word);
            hm.put(k,ls);
        }
        return new ArrayList<>(hm.values());
    }
}
