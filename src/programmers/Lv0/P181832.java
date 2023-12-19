package programmers.Lv0;

import java.util.Arrays;
import java.util.Scanner;

public class P181832 {

    private static int[][] answer;
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        answer = new int[n][n];
        DFS(0, 0, 1, directions[0]);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }

    private static void DFS(int row, int col, int number, int[] direction) {
        answer[row][col] = number;
        int x = direction[0];
        int y = direction[1];
        if (isInRange(row + x, col + y)) {
            DFS(row + x, col + y, number + 1, direction);
        } else {
            for (int i = 0; i < directions.length; i++) {
                x = directions[i][0];
                y = directions[i][1];
                if (isInRange(row + x, col + y)) {
                    DFS(row + x, col + y, number + 1, directions[i]);
                }
            }
        }
    }

    private static boolean isInRange(int row, int col) {
        return row < n && row >= 0 && col < n && col >= 0 && answer[row][col] == 0;
    }
}
