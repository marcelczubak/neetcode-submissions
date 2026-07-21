class Solution {


    public int coinChange(int[] coins, int amount) {
        
        Map<Integer, Integer> memo = new HashMap<>();
        
        int result = numberOfCoins(memo, coins, amount);

        return (result != Integer.MAX_VALUE) ? result : -1;

    }

    private int numberOfCoins(Map<Integer, Integer> memo, int[] coins, int amount) {

        if (amount < 0) return Integer.MAX_VALUE;
        if (amount == 0) return 0;

        if (memo.containsKey(amount)) return memo.get(amount);

        int answer = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = numberOfCoins(memo, coins, amount - coin);
            if (res != Integer.MAX_VALUE) answer = Math.min(answer, 1 + res);
        }

        memo.put(amount, answer);
        return answer;
    }
}
