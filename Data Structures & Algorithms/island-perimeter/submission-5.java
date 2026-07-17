class Solution {

    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    dfs(grid, visited, row, col);
                    break;
                }
            }
        }
        return perimeter;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] != 1) return;

        visited[row][col] = true;

        this.perimeter += addPerimeter(grid, row, col);

        dfs(grid, visited, row+1, col);
        dfs(grid, visited, row-1, col);
        dfs(grid, visited, row, col+1);
        dfs(grid, visited, row, col-1);
    }

    private int addPerimeter(int[][] grid, int row, int col) {

        int thisPerimeter = 0;

        if (col+1 < grid[0].length && grid[row][col+1] == 1) thisPerimeter++;
        if (col-1 >= 0 && grid[row][col-1] == 1) thisPerimeter++;
        if (row+1 < grid.length && grid[row+1][col] == 1) thisPerimeter++;
        if (row-1 >= 0 && grid[row-1][col] == 1) thisPerimeter++;

        return (4 - thisPerimeter);
    }

}