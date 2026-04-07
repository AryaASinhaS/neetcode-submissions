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

        Stack<ArrayList<Integer>> st = new Stack<>();
        int len = temperatures.length;
        int[] result = new int[len];

        ArrayList<Integer> firstTemp = new ArrayList<>();
        firstTemp.add(temperatures[0]);
        firstTemp.add(0);
        st.push(firstTemp);

        for(int i = 1; i < len; i++)
        {
            int currTemp = temperatures[i];

            while(st.size() > 0 && currTemp > st.peek().get(0))//peekTemp
            {
                ArrayList<Integer> t = st.pop();
                int index = t.get(1);
                result[index] = i - index;
            }
            
            ArrayList<Integer> smallerTemp = new ArrayList<>();
            smallerTemp.add(temperatures[i]);
            smallerTemp.add(i);
            st.push(smallerTemp);
        }
        return result;
    }
}
