class Solution {
    HashMap<String, Boolean> hm;
    public boolean wordBreak(String s, List<String> wordDict) {
        hm = new HashMap<>();
        return wordBreakRecFunc(s, wordDict);
            
    }

    public boolean wordBreakRecFunc(String s, List<String> wordDict) {
        
        boolean matched = false;
        
        if(s.length() == 0)
            return true;
        
        if(hm.containsKey(s))
            return hm.get(s);

        for(String wd : wordDict)
        {
            if(s.indexOf(wd) == 0)
            {
                String str = s.substring(wd.length());
                matched = matched || wordBreakRecFunc(str, wordDict);
            }
        }
        hm.put(s, matched);
        return matched;
    }
}
