package baekjoon.DP;

import java.util.Scanner;

public class 일로만들기_1463 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] memo = new int[N + 1];
        memo[1] = 0;
        for (int X = 2; X <= N; X++) {
            memo[X] = memo[X - 1] + 1;
            if (X % 2 == 0) {
                memo[X] = Math.min(memo[X], memo[X / 2] + 1);
            }
            if (X % 3 == 0) {
                memo[X] = Math.min(memo[X], memo[X / 3] + 1);
            }
        }
        System.out.print(memo[N]);
    }
}
