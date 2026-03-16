package baekjoon.silver;

import java.util.Scanner;

public class P1850_최대공약수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        System.out.print(GCD(Math.max(A, B), Math.min(A, B)));
    }

    private static String GCD(long A, long B) {
        if (A % B == 0) {
            return "1".repeat(Math.toIntExact(B));
        }

        return GCD(B, A % B);
    }

}
