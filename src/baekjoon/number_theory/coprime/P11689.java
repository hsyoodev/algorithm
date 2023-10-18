package baekjoon.number_theory.coprime;

import java.util.Scanner;

public class P11689 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long answer = N;
        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                answer -= answer / i;
            }
            while (N % i == 0) {
                N /= i;
            }
        }
        if (N > 1) {
            answer -= answer / N;
        }
        System.out.print(answer);
    }
}
