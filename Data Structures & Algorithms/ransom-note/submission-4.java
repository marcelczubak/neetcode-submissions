class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] freqMap = new int[26];

        for (char c : ransomNote.toCharArray()) {
            freqMap[c - 'a']--;
        }

        for (char c : magazine.toCharArray()) {
            freqMap[c - 'a']++;
        }

        for (int num : freqMap) if (num < 0) return false;


        return true;



    }
}