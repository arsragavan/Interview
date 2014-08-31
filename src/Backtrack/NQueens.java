package Backtrack;

public class NQueens {

    static boolean[][] board;

    public static boolean nQueens(int col) {

        if (col >= board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(i, col)) {
                board[i][col] = true;
                if (nQueens(col + 1)) {
                    return true;
                }
                board[i][col] = false;
            }
        }
        return false;
    }

    public static boolean isValid(int row, int col) {
        int n = board.length;
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int n = 7;
        board = new boolean[n][n];
        if (nQueens(0)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println("");
            }
        }

    }
}
