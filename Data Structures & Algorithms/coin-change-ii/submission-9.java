class Solution {
    public int change(int amount, int[] coins) {

        // <currentIndex+","+remaining --> numWays>
        Map<String, Integer> cache = new HashMap<>();
        
        int ways = 0;

        ways += tryCombinations(cache, 0, amount, coins);

        return ways;

    }

    private int tryCombinations(Map<String, Integer> cache, int currentIndex, int amount, int[] coins) {

        String key = stringify(currentIndex, amount); 

        if (cache.containsKey(key)) return cache.get(key);

        if (amount == 0) return 1;
        if (amount < 0) return 0;

        int ways = 0;

        for (int i = currentIndex; i < coins.length; i++) {
            ways += tryCombinations(cache, i, amount - coins[i], coins);
        }

        cache.put(key, ways);

        return ways;
    }

    private String stringify(int a, int b) {
        return (String.valueOf(a) + "," + String.valueOf(b));
    }

}
