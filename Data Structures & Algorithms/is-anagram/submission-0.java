class Solution {
    public boolean isAnagram(String s, String t) {
        
        // if lengths differ
        if(s.length() != t.length()) return false;

        // Populate frequency map for string s
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!freqMap.containsKey(c)) {
                freqMap.put(c, 1);
            } else {
                freqMap.put(c, freqMap.getOrDefault(c, 0) +1);
            }
        }

        // Subtract freq counts from string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (freqMap.containsKey(c)) {
                if (freqMap.get(c) <= 0) {
                    return false;
                }
                freqMap.put(c, freqMap.get(c) -1);
            }
            if (!freqMap.containsKey(c)) {
                return false;
            }


        }

        return true;


    }
}
