class MinStack {

    public Stack<Integer> minStack;
    public Stack<Integer> minValStack;
    int minVal = Integer.MAX_VALUE;


    public MinStack() {
        minStack = new Stack<>();
        minValStack = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= minVal)
        {
            minValStack.push(minVal);
            minVal = val;
        }
        
        minStack.push(val);
    }
    
    public void pop() {
        int poppedVal = minStack.pop();
        if(poppedVal == minVal)
        {
            minVal = minValStack.peek();
            minValStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minVal;
    }
}
