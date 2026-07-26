class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        StringBuilder prefix = new StringBuilder();

        // Goes through every character of the first word
        for (int i = 0; i < strs[0].length(); i++) {
            
            char compareChar = strs[0].charAt(i);

            // Check all other words against this character at i
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i) return prefix.toString();
                if (strs[j].charAt(i) != compareChar) return prefix.toString();
            }

            prefix.append(compareChar);

        }

        return prefix.toString();
    }
}