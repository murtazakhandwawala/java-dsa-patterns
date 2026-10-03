class MinStack {
        // so the main idea here is to implement the min fucntion - how to get the min value in o(1)
        // so we will implment two list - one to contain the actual values entered by user and other to maintain the min at that position.

        LinkedList<Integer> stack;
        LinkedList<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
         minStack.push(val);
        }
        else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
                minStack.pop();
            stack.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.getFirst();
        return 0;
    }
    
    public int getMin() {
        if(!stack.isEmpty() && !minStack.isEmpty())
            return minStack.getFirst();
            return 0;
    }
}
