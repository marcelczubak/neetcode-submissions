class Solution {
    public int change(int amount, int[] coins) {

        // <currentIndex+","+remaining --> numWays>

        int[][] cache = new int[coins.length][amount+1];
        
        int ways = 0;

        ways += tryCombinations(cache, 0, amount, coins);

        return ways;

    }

    private int tryCombinations(int[][] cache, int currentIndex, int amount, int[] coins) {
        
        if (amount < 0) return 0;
        if (amount == 0) return 1;

        if (cache[currentIndex][amount] != 0) return cache[currentIndex][amount];

        int ways = 0;

        for (int i = currentIndex; i < coins.length; i++) {
            ways += tryCombinations(cache, i, amount - coins[i], coins);
        }

        cache[currentIndex][amount] = ways;

        return ways;
    }

    private String stringify(int a, int b) {
        return (String.valueOf(a) + "," + String.valueOf(b));
    }

}
