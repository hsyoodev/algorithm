package baekjoon.mathematics;

import java.util.Scanner;

public class 소수구하기_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] answer = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            answer[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (answer[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j+=i) {
                answer[j] = 0;
            }
        }
        for (int i = M; i <= N; i++) {
            if (answer[i] != 0) {
                System.out.println(answer[i]);
            }
        }
    }
}
