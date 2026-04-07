class Solution {
    public boolean isValid(String s) {

        if(s.length() <= 1)
            return false;

        Stack<Character> st = new Stack<>();
        char pairBracket = ' ';

        for(char c : s.toCharArray())
        {
            if(c == '(' || c == '{' || c == '[')
            {
                st.push(c);
            }
            else
            {
                if(st.size() > 0)
                    pairBracket = st.pop();
                if((c == ')' && pairBracket != '(') || (c == '}' && pairBracket != '{') || (c == ']' && pairBracket != '['))
                    return false;
            }
        }

        return (st.size() > 0 ? false : true);
    }
}
