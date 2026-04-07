class Solution {
    public int evalRPN(String[] tokens) {
        /**
        IP : String Array
        OP: Integer , resultant value
        Edge Case : Invalid notation /// assumption - valid
        Approach :
        Traverse the str
        if its a number, push it to stack
        else pop 2 values, co,pute result and push it back to string
        oncew we reach end of string, return result as stack's pop

        **/

        int len = tokens.length;
        
        Stack<String> st = new Stack<>();

        for(int i = 0; i < len; i++)
        {
            String curr = tokens[i];
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/"))
            {
                int operand1 = Integer.parseInt(st.pop());
                int operand2 = Integer.parseInt(st.pop());

                int result = 0;

                switch(curr)
                {
                    case "+" : result = operand2 + operand1;
                    break;
                    case "-" : result = operand2 - operand1;
                    break;
                    case "*" : result = operand2 * operand1;
                    break;
                    case "/" : result = operand2 / operand1;
                    break;
                }
                String resultStr = result + "";
                st.push(resultStr);
            }
            else
            {
                st.push(curr);
            }
        }


        String  curr = st.pop();
        int res = res = Integer.parseInt(curr);
        
        return res;
    }
}
