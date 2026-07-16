class Solution {
    public String largestGoodInteger(String num) {
        
        int largestGoodNumber = -1;

        // Window of size 3
        int left = 0;
        int right = 3;

        while (right <= num.length()) {

            String substring = num.substring(left, right);
            if (isGoodInteger(substring)) largestGoodNumber = Math.max(largestGoodNumber, Integer.parseInt(substring));

            left++;
            right++;

        }

        if (largestGoodNumber < 0) return "";

        return largestGoodNumber == 0 ? "000" : String.valueOf(largestGoodNumber);

    }   

    private boolean isGoodInteger(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i-1)) return false;
        }
        return true;
    }
}