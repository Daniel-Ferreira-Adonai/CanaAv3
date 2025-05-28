package Problem6;

public class Main {
    public static void main(String[] args) {
        KnightTourSolver solver = new KnightTourSolver();
        int[][] board = new int[solver.boardSize][solver.boardSize];

        //populando tabuleiro
        for (int i = 0; i < solver.boardSize; i++)
            for (int j = 0; j < solver.boardSize; j++)
                board[i][j] = -1;


        int startX = 0, startY = 0;
        board[startX][startY] = 0;
        if (solver.solve(board, startX, startY, 1)) {
            solver.printBoard(board);
        } else {
            System.out.println("Can't find a solution : )");
        }
    }
}
