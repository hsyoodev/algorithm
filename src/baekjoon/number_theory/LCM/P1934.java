package baekjoon.number_theory.LCM;

import java.util.Scanner;

public class P1934 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            LCM(A, B);
        }
    }

    public static void LCM(int A, int B) {
        int gcd = GCD(A, B);
        System.out.println(A * B / gcd);
    }

    public static int GCD(int A, int B) {
        while (B % A != 0) {
            int temp = A;
            A = B % A;
            B = temp;
        }
        return A;
    }
}
