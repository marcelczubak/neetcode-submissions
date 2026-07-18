class Solution {
    public int arrangeCoins(int n) {
        
        int result = 0;

        int left = 0;
        int right = n;

        while (left <= right) {

            int mid = (left) + (right - left) / 2;

            long coinsNeeded = ((long)mid * (mid+1))/2;

            if (n < coinsNeeded) {
                // Not enough coins
                right = mid-1;
            } else {
                result = mid;
                left = mid+1;
            }
        }

        return result;
    }
}