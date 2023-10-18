package programmers.LV2;

public class 가장큰정사각형찾기_12905 {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 1}};
        int answer = 0;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] > 0) {
                    int up = (y - 1 >= 0) ? board[x][y - 1] : 0;
                    int left = (x - 1 >= 0) ? board[x - 1][y] : 0;
                    int diagonal = (x - 1 >= 0 && y - 1 >= 0) ? board[x - 1][y - 1] : 0;
                    board[x][y] = Math.min(Math.min(up, left), diagonal) + 1;
                    answer = Math.max(answer, board[x][y]);
                }
            }
        }
        System.out.print(answer * answer);
    }
}
