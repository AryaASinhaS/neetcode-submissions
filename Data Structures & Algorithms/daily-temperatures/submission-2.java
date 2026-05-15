class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        /**

        IP: Integer array containing tht day's temp
        OP: Integer Array denoting no. of days with next highest temp
        Edge Case: Empty array
        Approach:

        Iterate in array
        push 1st value in stack
        next index onwards, if current temp is greater than peek of stack then pop the values till temp is less than current temp
        if current temp is less than peek then push along with index
        for each popped value fill result array with popped index as current - popped
        **/

        int n = temperatures.length;

        int[] result = new int[n];

        if(n == 1)
            return result;
        
        Stack<ArrayList<Integer>> st = new Stack<>();
        
        for(int i = n-1; i >= 0; i--)
        {
            int count = 0;
            if(st.size() > 0 && st.peek().get(0) > temperatures[i])
            {
                result[i] = 1;
            }
            else
            {
                while(st.size() > 0 && st.peek().get(0) <= temperatures[i])
                {
                    st.pop();
                    count++;
                }
                if(st.size() > 0)
                    result[i] = st.peek().get(1) - i;
            }
            st.push(new ArrayList<>(List.of(temperatures[i], i)));   
            
        }
        return result;
    }
}
