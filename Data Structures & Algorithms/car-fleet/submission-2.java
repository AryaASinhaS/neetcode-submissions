class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {

        /**
        IP: target, position Integer array, speed Integer array
        OP: Integer, no. of fleets
        Edge Case: no cars, return 0
        Approach:

        create a time array of size target and fill time[pos] = (target-pos[i])/speed[i]; if speed[i] = 0, make time[pos] = 0
        insert all time[pos] >= 0 to stack
        iterate the stack , in each iteration check for previously popped value 
        if(pop < curr) fleet++
        return fleet
        **/

        double[] time = new double[target];
        Stack<Double> st = new Stack<>();
        int n = pos.length, fleet = 0;

        for(int i = 0; i < n; i++)
        {
            time[pos[i]] = (speed[i] == 0 ? 0 : (double)((target - pos[i]))/speed[i]);
        }

        for(int i = 0; i < target; i++)
        {
            if(time[i] > 0)
            {
                st.push(time[i]);
            }
        }

        double aheadSpeed = 0;

        while(st.size() > 0)
        {
            double curr = st.pop();
            if(aheadSpeed < curr)
            {
                fleet++;
                aheadSpeed = curr;
            }
        }
        
        return fleet;
    }
}
