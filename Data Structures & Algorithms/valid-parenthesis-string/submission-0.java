class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftStack.push(i);
            if (s.charAt(i) == '*') starStack.push(i);

            if (s.charAt(i) == ')') {
                if (!leftStack.isEmpty()) leftStack.pop();
                else if (!starStack.isEmpty()) starStack.pop();
                else return false;
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {

            if (leftStack.pop() > starStack.pop()) return false;

        }

        if (starStack.isEmpty() && !leftStack.isEmpty()) return false;

        return true;
    }
}
