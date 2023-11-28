package SWEA.D2;

import java.util.Scanner;

public class P1954 {

    private static int N;
    private static int[][] snail;
    private static int[][] vector = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            N = scanner.nextInt();
            snail = new int[N][N];
            DFS(0, 0, 0, 0);
            System.out.printf("#%d\n", testCase);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%d ", snail[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static void DFS(int x, int y, int number, int direction) {
        if (snail[x][y] != 0) {
            return;
        }
        snail[x][y] = number + 1;
        int nextX = x + vector[direction][0];
        int nextY = y + vector[direction][1];
        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
            DFS(nextX, nextY, snail[x][y], direction);
        }
        for (int i = 0; i < 4; i++) {
            nextX = x + vector[i][0];
            nextY = y + vector[i][1];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                DFS(nextX, nextY, snail[x][y], i);
            }
        }
    }
}
