class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                
                int last = Math.abs(stack.peek());
                int newAst = Math.abs(asteroid);

                if (last <= newAst) stack.pop();
                
                if (last >= newAst) {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) stack.push(asteroid);
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size()-1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}