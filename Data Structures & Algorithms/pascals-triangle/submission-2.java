class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {

            // This row
            List<Integer> thisRow = new ArrayList<>();
            
            // Row n contains n numbers
            for (int i = 1; i <= row; i++) {

                // Generates the first and last number in each row
                if (i == 1 || i == row) {
                    thisRow.add(1);
                } else {
                    // Generate the numbers in between
                    List<Integer> prevRow = result.get(result.size() - 1);
                    thisRow.add(prevRow.get(i-2) + prevRow.get(i-1));
                }
            }
            result.add(thisRow);
        }
        return result;
    }
}