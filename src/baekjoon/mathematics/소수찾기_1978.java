package baekjoon.mathematics;

import java.util.Scanner;

public class 소수찾기_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = N;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                answer--;
            } else {
                for (int j = 2; j <= Math.sqrt(num) ; j++) {
                    if (num % j == 0) {
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
