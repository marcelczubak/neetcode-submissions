class Solution {
    private int ROWS;
    private int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        // Pacific: top row
        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific);
        }

        // Pacific: left column
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific);
        }

        // Atlantic: bottom row
        for (int c = 0; c < COLS; c++) {
            dfs(heights, ROWS - 1, c, atlantic);
        }

        // Atlantic: right column
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, COLS - 1, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        if (visited[r][c])
            return;

        visited[r][c] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !visited[nr][nc]
                && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}