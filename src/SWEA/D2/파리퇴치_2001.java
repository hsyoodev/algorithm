package SWEA.D2;

import java.util.Scanner;

public class 파리퇴치_2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] flyArea = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    flyArea[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int k = i; k < i + M; k++) {
                        for (int l = j; l < j + M; l++) {
                            sum += flyArea[k][l];
                        }
                    }
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, max);
        }
    }
}
