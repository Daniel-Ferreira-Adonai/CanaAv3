package Problem6;

public class KnightTourSolver {

    public int boardSize = 8;

      public int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
      public int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};



    public boolean solve(int[][] board, int x, int y, int moveCount) {
        if (moveCount == boardSize * boardSize) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if (isSafe(board, nextX, nextY)) {
                board[nextX][nextY] = moveCount;
                //tenta colocar na proxima posição
                if (solve(board, nextX, nextY, moveCount + 1)) {
                    return true;
                } else {
                    //se n funfar ele desfaz
                    board[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    public void printBoard(int[][] board) {
        System.out.println("KnightTour problem solution");
        for (int[] row : board) {
            for (int val : row) {
                System.out.printf("%2d ", val);
            }
            System.out.println();
        }
    }

        //verifica se ja esta ocupado e se esta dentro do limite do tabuleiro
    public boolean isSafe(int[][] board, int x, int y) {
        return (x >= 0 && x < boardSize && y >= 0 && y < boardSize && board[x][y] == -1);
    }
}
