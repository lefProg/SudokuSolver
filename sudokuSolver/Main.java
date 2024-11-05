import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[9][9];

        System.out.println("Enter the Sudoku board (9 lines with 9 characters each, '.' for empty cells):");

        for (int i = 0; i < 9; i++) {
            // Read the line and remove spaces
            String line = scanner.nextLine().replace(" ", "").trim();

            // Ensure the line has exactly 9 characters
            if (line.length() != 9) {
                System.out.println("Invalid row length. Each row must contain exactly 9 characters.");
                scanner.close();
                return;
            }

            // Fill the board row by row
            for (int j = 0; j < 9; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        scanner.close();

        SudokuSolver solver = new SudokuSolver();
        System.out.println("Original board:");
        printBoard(board);

        // Solve the Sudoku
        if (solver.solveSudoku(board)) {
            System.out.println("Solved board:");
            printBoard(board);
        } else {
            System.out.println("No solution exists for this board.");
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();  // Newline after each row
        }
    }
}
