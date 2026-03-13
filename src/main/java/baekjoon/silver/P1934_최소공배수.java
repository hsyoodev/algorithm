package baekjoon.silver;

import java.util.Scanner;

public class P1934_최소공배수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int max = Math.max(A, B);
            int min = Math.min(A, B);

            System.out.println(A * B / GCD(max, min));
        }
    }

    private static int GCD(int A, int B) {
        if (A % B == 0) {
            return B;
        }

        return GCD(B, A % B);
    }

}
