class Solution {
    public int reverse(int x) {
        
        int result = 0;

        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        while (x != 0) {

            // Extract last digit
            int digit = x % 10;

            if (result > MAX/10) return 0;
            if (result == MAX/10 && digit > 7) return 0;
            if (result < MIN/10) return 0;
            if (result == MIN/10 && digit < -8) return 0;

            result = result * 10 + digit;

            x /= 10;
        }


        return result;
    }   
}