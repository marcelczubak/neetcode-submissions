class Solution {
    public int countSubstrings(String s) {
        
        int substrings = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                substrings++;
            }


        }

        for (int i = 0; i < s.length()-1; i++) {
            int left = i, right = i+1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                substrings++;
            }


        }



        return substrings;
    }
}
