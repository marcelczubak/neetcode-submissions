class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {

                if (i == j) continue;

                if (isSubstring(words[i], words[j]) && !result.contains(words[i])) result.add(words[i]);

            }
        }

        return result;
    }

    private boolean isSubstring(String word1, String word2) {

        if (word1.length() > word2.length()) return false;

        for (int i = 0; i <= word2.length() - word1.length(); i++) {

            int j = 0;

            while (j < word1.length() &&
                word1.charAt(j) == word2.charAt(i + j)) {
                j++;
            }

            if (j == word1.length()) return true;
        }

        return false;
    }

}