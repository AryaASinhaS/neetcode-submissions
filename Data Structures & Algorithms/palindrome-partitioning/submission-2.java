class Solution {
    public List<List<String>> partition(String s) {
        return makeAllSubstrings(s);
    }

    //fn to make all substrings
    public static List<List<String>> makeAllSubstrings(String s)
    {
        List<List<String>> result = new ArrayList<>();
        
        
        if(s.length() == 0)
        {
            result.add(new ArrayList<>());
            return result;
        }
        
        if(s.length() == 1)
        {
            
            result.add(new ArrayList<>(List.of(s)));
            return result;
        }
        
        for(int i = 1; i <= s.length(); i++)
        {
            List<List<String>> temp = new ArrayList<>();
            List<List<String>> currResult = new ArrayList<>();
            //we will consider i length of characters as fixed and choose substrings from remaining
            String prefix = s.substring(0, i); //"a"
            if(isPalindrome(prefix))
            {
                temp = makeAllSubstrings(s.substring(i)); //{{"b"} ,{"a"}}
                List<String> appendedList;
                for(List<String> curr : temp)
                {
                    appendedList = new ArrayList<>(curr);
                    appendedList.add(0, prefix); // {"a", "b"}
                    result.add(appendedList); 
                }
            }
            
            
        }
        return result;
    }
    
    //fn to check palindrome string
    public static boolean isPalindrome(String s)
    {
        StringBuilder org = new StringBuilder(s);
        String rev = org.reverse().toString();
        return s.equals(rev);
    }
}
