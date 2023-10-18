package programmers.LV2;

public class 가장큰정사각형찾기_12905 {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 1}};
        int rows = board.length;
        int cols = board[0].length;
        for (int x = 1; x < rows; x++) {
            board[x][0] += board[x - 1][0];
        }
        for (int y = 1; y < cols; y++) {
            board[0][y] += board[0][y - 1];
        }
        for (int x = 1; x < rows; x++) {
            for (int y = 1; y < cols; y++) {
                board[x][y] += board[x - 1][y] + board[x][y - 1] - board[x - 1][y - 1];
            }
        }
        // for(int[] a : board) {
        //     System.out.println(Arrays.toString(a));
        // }
        int min = rows < cols ? rows : cols;
        for (int i = min; i >= 1; i--) {
            for (int x1 = 0; x1 < rows - (i - 1); x1++) {
                for (int y1 = 0; y1 < cols - (i - 1); y1++) {
                    int x2 = x1 + (i - 1);
                    int y2 = y1 + (i - 1);
                    int area = board[x2][y2];
                    if (x1 > 0 && y1 > 0) {
                        area -= (board[x1 - 1][y2] - board[x2][y1 - 1] + board[x1 - 1][y1 - 1]);
                    } else if (x1 > 0) {
                        area -= board[x1 - 1][y2];
                    } else if (y1 > 0) {
                        area -= board[x2][y1 - 1];
                    }
                    // System.out.println(x1);
                    // System.out.println(y1);
                    // System.out.println(x2);
                    // System.out.println(y2);
                    // System.out.println(area);
                    if (area == i * i) {
                        System.out.print(area);
                        System.exit(0);
                    }
                }
            }
        }
        System.out.print(0);
    }
}
