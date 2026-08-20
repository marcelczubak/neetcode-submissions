class Solution {
    public String convertToTitle(int columnNumber) {
        
        StringBuilder result = new StringBuilder();

        int current = columnNumber;

        while (current > 0) {

            current--;

            int res = current / 26;
            int rem = current % 26;

            result.append((char) (rem + 'A'));

            current = res;
        }



        return result.reverse().toString();
    }
}