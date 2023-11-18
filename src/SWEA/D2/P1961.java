package SWEA.D2;

import java.util.Scanner;

public class P1961 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[][] numbers = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    numbers[i][j] = scanner.nextInt();
                }
            }
            int[][] numbers90 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    numbers90[i][j] = numbers[N - 1 - j][i];
                }
            }

            int[][] numbers180 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    numbers180[i][j] = numbers90[N - 1 - j][i];
                }
            }

            int[][] numbers270 = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    numbers270[i][j] = numbers180[N - 1 - j][i];
                }
            }
            System.out.printf("#%d\n", testCase);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(numbers90[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(numbers180[i][j]);
                }
                System.out.print(" ");
                for (int j = 0; j < N; j++) {
                    System.out.print(numbers270[i][j]);
                }
                System.out.println();
            }
        }
    }
}
