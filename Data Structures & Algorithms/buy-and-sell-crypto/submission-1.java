class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;

        int minPrice = prices[0];

        for (int price : prices) {

            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);

            if (price < minPrice) {
                minPrice = price;
            } 
        }
        return maxProfit;
    }
}
