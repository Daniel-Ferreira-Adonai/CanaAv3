package Problem2;

public class Main {
    public static class NQueenSolver {
        private final int N;

        public NQueenSolver(int N) {
            this.N = N;
        }

        public boolean solveNQueens(int[][] board, int row) {
            if (row == N) {
                return true;
            }

            for (int col = 0; col < N; col++) {
                if (isSafe(board, row, col)) {
                    board[row][col] = 1;

                    if (solveNQueens(board, row + 1)) {
                        System.out.println("true in: " + row + " " + col);
                        return true;
                    }

                    System.out.println("backtrack on: " + row + " " + col);
                    board[row][col] = 0; // backtrack aqui
                }
            }
            return false;
        }

        public boolean isSafe(int[][] board, int row, int col) {
            // olha a coluna inteira pra cima
            for (int i = 0; i < row; i++)
                if (board[i][col] == 1)
                    return false;
            // Diagonal superior esquerda
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 1)
                    return false;
            // Diagonal superior direita
            for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++)
                if (board[i][j] == 1)
                    return false;
            return true;
        }

        public void populateBoard(int[][] board) {
            for (int i = 0; i < board.length; i++)
                for (int j = 0; j < board[i].length; j++)
                    board[i][j] = 0;
        }

        public void printBoard(int[][] board) {
            for (int[] row : board) {
                for (int cell : row)
                    System.out.print(cell == 1 ? "Q " : ". ");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int N = 8;
        int[][] board = new int[N][N];
        NQueenSolver solver = new NQueenSolver(N);
        solver.populateBoard(board);

        if (solver.solveNQueens(board, 0)) {
            solver.printBoard(board);
        } else {
            System.out.println("No solution found.");
        }
    }
}
