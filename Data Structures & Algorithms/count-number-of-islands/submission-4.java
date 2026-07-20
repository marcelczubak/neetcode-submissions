class Solution {
    public int numIslands(char[][] grid) {
        
        int numIslands = 0;

        // Visit every cell in the grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                
                if (grid[row][col] == '1') {
                    countIslands(grid, row, col);
                    numIslands++;
                }

            }
        }

        return numIslands;
    }

    private void countIslands(char[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return ;

        grid[row][col] = '0';

        countIslands(grid, row+1, col);
        countIslands(grid, row-1, col);
        countIslands(grid, row, col+1);
        countIslands(grid, row, col-1);

    }

}
