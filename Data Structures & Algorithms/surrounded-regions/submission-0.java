class Solution {
    public void solve(char[][] board) {
        
        // Perform DFS from all Os along the border
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // Ignore middle
                if (row > 0 && row < board.length-1 && col > 0 && col < board[0].length-1) continue;

                // Border cells only
                if (board[row][col] == 'O') dfs(board, row, col);

            }
        }

        
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                // Capture all unmarked cells
                if (board[row][col] == 'O') board[row][col] = 'X';

                // Unmark all # cells back to 0 cells
                if (board[row][col] == '#') board[row][col] = 'O';

            }
        }

    }

    private void dfs(char[][] board, int row, int col) {

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') return;

        // Mark cell as visited
        board[row][col] = '#';

        dfs(board, row+1, col);
        dfs(board, row, col+1);
        dfs(board, row-1, col);
        dfs(board, row, col-1);

    }

}
