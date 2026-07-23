class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        
        // Reverse matrix vertically (first row becomes last row)
        for (int i = 0; i < n/2; i++) {

            int[] thisRow = matrix[i];
            
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = thisRow;

        }   

        // Transpose matrix (rows become cols)
        // [r,c] -> [c,r]   (only consider upper triangular, above main diagonal)
        for (int row = 0; row < n; row++) {
            for (int col = row+1; col < n; col++) {

                int thisCell = matrix[row][col];

                matrix[row][col] = matrix[col][row];
                matrix[col][row] = thisCell;
            }
        }
    }
}
