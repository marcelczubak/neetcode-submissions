class MyQueue {

    Integer top;
    Stack<Integer> stack1;
    Stack<Integer> stack2;    

    public MyQueue() {
        top = null;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        if (top == null) {
            top = x;
            return;
        }

        stack2.push(x);
        
    }
    
    public int pop() {
        int popMe = top;

        // extract the new top with reshuffling
        while (stack2.size() > 1) {
            stack1.push(stack2.pop());
        }

        if (!stack2.isEmpty()) top = stack2.pop();
        else top = null;

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return popMe;
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() {
        return (top == null && stack2.isEmpty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */