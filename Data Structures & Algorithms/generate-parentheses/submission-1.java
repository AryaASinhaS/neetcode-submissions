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
            result = formString("(", temp);
        }
        
        if(close > open)
        {
            List<String> temp = formCombinations(open, close - 1);
            result.addAll(formString(")", temp));
        }

        return result;
    }

    public List<String> formString(String bracket, List<String> temp)
    {
        List<String> result = new ArrayList<>();
        for(String s : temp)
        {
            String newS = bracket + s;
            result.add(newS);
        }
        return result;
    }
}
