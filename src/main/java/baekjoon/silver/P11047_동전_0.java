package baekjoon.silver;

import java.util.Scanner;

public class P11047_동전_0 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            answer += K / A[i];
            K %= A[i];
        }

        System.out.print(answer);
        scanner.close();
    }

}
