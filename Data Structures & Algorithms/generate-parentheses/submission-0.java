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
            List<String> temp = formCombinations(open - 1, close);
            for(String s : temp)
            {
                String newS = "(" + s;
                result.add(newS);
            }
        }
        
        if(close > open)
        {
            List<String> temp = formCombinations(open, close - 1);
            for(String s : temp)
            {
                String newS = ")" + s;
                result.add(newS);
            }
        }

        return result;
    }
}
