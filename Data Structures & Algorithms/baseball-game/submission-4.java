class Solution {
    public int calPoints(String[] operations) {
        
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(String operation : operations) {
            
            if (operation.equals("+")) {
                // Record a new score which is the sum of the two previous scores
                int num2 = stack.pop();
                int num1 = stack.peek();
                stack.push(num2);
                stack.push(num1 + num2);

            } else if (operation.equals("D")) {
                // Record a new score which is double the previous score
                stack.push(2*stack.peek());
            } else if (operation.equals("C")) {
                // Remove previous score
                stack.pop();
            } else {
                // Record a new integer score
                stack.push(Integer.parseInt(operation));
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}