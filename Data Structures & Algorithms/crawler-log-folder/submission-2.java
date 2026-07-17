class Solution {
    public int minOperations(String[] logs) {
        
        Stack<String> logStack = new Stack<>();

        for (String log : logs) {
            if (log.equals("./")) continue;

            if (log.equals("../")) {

                if (!logStack.isEmpty()) logStack.pop();
                
            } else {
                logStack.push(log);
            } 


        }

        return logStack.size();

    }
}