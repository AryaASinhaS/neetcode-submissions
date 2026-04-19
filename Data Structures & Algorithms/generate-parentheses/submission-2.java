class Solution {
    public List<String> generateParenthesis(int n) {

        return formCombinations(n,n);
        
    }

    public List<String> formCombinations(int open, int close)
    {
        List<String> result = new ArrayList<>();

       if(open == 0 && close == 0)
       {
            result.add("");
            return result;
       }

       if(open > 0)
       {
            List<String> currResult = formCombinations(open - 1, close);
            for(String s : formString("(", currResult))
            {
                result.add(s);
            }
       }

       if(close > open)
       {
            List<String> currResult = formCombinations(open, close - 1);
            for(String s : formString(")", currResult))
            {
                result.add(s);
            }
       }
       return result;
    }

    public List<String> formString(String bracket, List<String> currResult)
    {
        List<String> result = new ArrayList<>();
        for(String s : currResult)
        {
            String newS = bracket + s;
            result.add(newS);
        }
        return result;
    }
}
