package baekjoon.number_theory;

import java.util.Scanner;

public class P1934 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int LCM = getLCM(A, B);
            System.out.print(LCM);
        }
    }

    private static int getLCM(int A, int B) {
        int GCD = getGCD(A, B);
        return (A * B) / GCD;
    }

    private static int getGCD(int A, int B) {
        while (B % A != 0) {
            int temp = A;
            A = B % A;
            B = temp;
        }
        return A;
    }
}
