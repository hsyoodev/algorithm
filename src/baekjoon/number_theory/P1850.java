package baekjoon.number_theory;

import java.util.Scanner;

public class P1850 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long gcd = GCD(A, B);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            answer.append("1");
        }
        System.out.print(answer);
    }

    private static long GCD(long A, long B) {
        while (B % A != 0) {
            long temp = A;
            A = B % A;
            B = temp;
        }
        return A;
    }
}
