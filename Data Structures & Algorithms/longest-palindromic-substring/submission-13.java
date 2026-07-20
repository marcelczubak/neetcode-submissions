class Solution {
    public String longestPalindrome(String s) {

        if (s.length() == 1) return s;
        
        String longestPalindrome = s.substring(0,1);

        for (int i = 0; i < s.length(); i++) {

            int left = i-1;
            int right = i+1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                
                // Update substring if longer
                if (right - left + 1 > longestPalindrome.length()) longestPalindrome = s.substring(left, right+1);

                // Move pointers apart
                left--;
                right++;

            }

            left = i;
            right = i+1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                
                // Update substring if longer
                if (right - left + 1 > longestPalindrome.length()) longestPalindrome = s.substring(left, right+1);

                // Move pointers apart
                left--;
                right++;

            }


        }

        return longestPalindrome;
    }
}
