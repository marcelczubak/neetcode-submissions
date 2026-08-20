class Solution {
    public int openLock(String[] deadends, String target) {
        
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) dead.add(deadend);

        int moves = 0;

        queue.offer("0000");
        set.add("0000");

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String combination = queue.poll();

                if (dead.contains(combination)) continue;
                if (combination.equals(target)) return moves;

                // generate 8 possible new combinations
                List<String> newCombinations = generateNew(combination);

                for (String newCombination : newCombinations) {
                    if (!set.contains(newCombination)) {
                        queue.offer(newCombination);
                        set.add(newCombination);
                    }
                    
                }
            }

            moves++;

        }

        return -1;
    }   

    private List<String> generateNew(String combination) {

        List<String> all = new ArrayList<>();

        // Iterate through every wheel
        for (int i = 0; i < 4; i++) {

            int digit = (combination.charAt(i) - '0');

            StringBuilder incr = new StringBuilder(combination);
            StringBuilder decr = new StringBuilder(combination);

            incr.setCharAt(i, (digit == 9) ? (char) 0 + '0' : (char) (digit+1 + '0'));
            decr.setCharAt(i, (digit == 0) ? (char) 9 + '0' : (char) (digit-1 + '0'));

            all.add(incr.toString());
            all.add(decr.toString());

        }
        return all;
    }


}