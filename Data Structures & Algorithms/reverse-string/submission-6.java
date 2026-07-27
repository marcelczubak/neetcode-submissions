class Solution {
    public void reverseString(char[] s) {

        int n = s.length;
        
        for (int left = 0; left < n/2; left++){
            char temp = s[left];
            s[left] = s[n - 1 - left];
            s[n - 1 - left] = temp;
        }

    }
}