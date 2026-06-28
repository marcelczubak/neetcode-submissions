class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if (t.length() == 0) return false;
        if (s.length() == 0) return true;

        int a = 0;
        int b = 0;

        while(a < s.length() - 1 && b < t.length()-1) {
            if (s.charAt(a) == t.charAt(b)) {
                a++;
                b++;
            } else {
                b++;
            }
        }
        return (a >= s.length()-1);
    }
}