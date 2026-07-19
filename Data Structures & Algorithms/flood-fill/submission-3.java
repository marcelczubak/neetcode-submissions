class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor != color) {
            dfs(image, sr, sc, color, originalColor);
        }

        return image;
    }

    private void dfs(int[][] image, int row, int col, int color, int prevColor) {
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != prevColor) return;

        int thisColor = image[row][col];

        // color == prevColor
        image[row][col] = color;

        dfs(image, row+1, col, color, thisColor);
        dfs(image, row-1, col, color, thisColor);
        dfs(image, row, col+1, color, thisColor);
        dfs(image, row, col-1, color, thisColor);
    }
}