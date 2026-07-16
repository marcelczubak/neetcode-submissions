class Solution {
    public int lengthOfLastWord(String s) {
        int startIndex = s.length() - 1;

        while(s.charAt(startIndex) == ' ') {
            startIndex--;
        }

        for (int i = startIndex; i >= 0; i--) {
            if (s.charAt(i) == ' ') return (startIndex - i);
        }
        return 1;
    }
}