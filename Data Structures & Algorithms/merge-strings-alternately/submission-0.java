class Solution {
    public String mergeAlternately(String word1, String word2) {
        int index = 0;

        StringBuilder result = new StringBuilder();

        while (index < word1.length() || index < word2.length()) {
            if (index < word1.length()) result.append(word1.charAt(index));
            if (index < word2.length()) result.append(word2.charAt(index));
            index++; 
        }
        return result.toString();
    }
}