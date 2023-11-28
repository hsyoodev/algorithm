package SWEA.D2;

import java.util.Scanner;

public class P1959 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] numbersA = new int[N];
            int[] numbersB = new int[M];
            for (int i = 0; i < N; i++) {
                numbersA[i] = scanner.nextInt();
            }
            for (int i = 0; i < M; i++) {
                numbersB[i] = scanner.nextInt();
            }
            int answer = 0;
            if (numbersA.length < numbersB.length) {
                for (int i = 0; i <= (M - N); i++) {
                    int temp = 0;
                    for (int j = 0; j < N; j++) {
                        temp += numbersA[j] * numbersB[j + i];
                    }
                    answer = Math.max(answer, temp);
                }
            } else {
                for (int i = 0; i <= (N - M); i++) {
                    int temp = 0;
                    for (int j = 0; j < M; j++) {
                        temp += numbersB[j] * numbersA[j + i];
                    }
                    answer = Math.max(answer, temp);
                }
            }
            System.out.printf("#%d %d", testCase, answer);
        }
    }
}
