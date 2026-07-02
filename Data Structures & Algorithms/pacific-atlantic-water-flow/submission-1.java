class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {

                boolean[][] visitedPacific = new boolean[heights.length][heights[0].length];
                boolean[][] visitedAtlantic = new boolean[heights.length][heights[0].length];

                if (canReachPacific(heights, r, c, visitedPacific) && canReachAtlantic(heights, r, c, visitedAtlantic)) {

                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private boolean canReachPacific(int[][] heights, int r, int c, boolean[][] visited) {

        if (r == 0 || c == 0) return true;

        visited[r][c] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !visited[nr][nc] &&
                heights[nr][nc] <= heights[r][c]) {

                if (canReachPacific(heights, nr, nc, visited))
                    return true;
            }
        }

        return false;
    }

    private boolean canReachAtlantic(int[][] heights, int r, int c, boolean[][] visited) {

        if (r == heights.length - 1 || c == heights[0].length - 1) return true;

        visited[r][c] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {

            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !visited[nr][nc] &&
                heights[nr][nc] <= heights[r][c]) {

                if (canReachAtlantic(heights, nr, nc, visited))
                    return true;
            }
        }

        return false;
    }
}