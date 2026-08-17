class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] letterOrder = new int[26];

        for (int i = 0; i < 26; i++) {
            letterOrder[order.charAt(i) - 'a'] = i;
        }

        // Compare adjacent pairs of words
        for (int i = 0; i < words.length-1; i++){

            String word1 = words[i];
            String word2 = words[i+1];

            boolean different = false;

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {

                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);

                // Comparing same character
                if (char1 == char2) continue;   

                // Ordering incorrect
                if (letterOrder[char1 - 'a'] > letterOrder[char2 - 'a']) return false;

                different = true;
                break;
            
            }
            if (!different && word1.length() > word2.length()) return false;

        }
        return true;
    }
}