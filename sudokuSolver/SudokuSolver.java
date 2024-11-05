public class SudokuSolver {

    public boolean solveSudoku(char[][] board) {
        return solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }
        if (col == board[0].length) {
            return solve(board, row + 1, 0);
        }
        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        for (char num = '1'; num <= '9'; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num;

                if (solve(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.'; // Reset on backtrack
            }
        }
        return false; // Added return statement
    }

    public boolean isValidPlacement(char[][] board, int row, int col, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }

            if (board[row][i] == num) {
                return false;
            }

            int subGridRow = 3 * (row / 3) + i / 3;
            int subGridCol = 3 * (col / 3) + i % 3;

            if (board[subGridRow][subGridCol] == num) {
                return false;
            }
        }
        return true;
    }
}
