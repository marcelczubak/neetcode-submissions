class Solution {
    public int maxProfit(int[] prices) {

        // <"day, holdingCoin" ---> maxProfit>
        Map<String, Integer> cache = new HashMap<>();

        return findProfit(cache, prices, 0, false);
    }

    private int findProfit(Map<String, Integer> cache, int[] prices, int i, boolean coinOwned) {

        if (i >= prices.length) return 0;

        String key = String.valueOf(i)+String.valueOf(coinOwned);

        Integer profit = cache.get(key);

        if (profit != null) return profit;

        int maxProfit = 0;

        if (coinOwned) {

            //                         sell today, skip a day                       keep holding the coin
            maxProfit = Math.max(prices[i] + findProfit(cache, prices, i+2, !coinOwned), findProfit(cache, prices, i+1, coinOwned));
        } else {
            //                         buy today, can sell the next day              still have no coin
            maxProfit = Math.max(findProfit(cache, prices, i+1, !coinOwned) - prices[i], findProfit(cache, prices, i+1, coinOwned));
        }

        cache.put(key, maxProfit);

        return maxProfit;
    }

}
