package baekjoon.silver;

import java.util.Scanner;

public class P1929_소수_구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = Math.max(2, scanner.nextInt());
        int N = scanner.nextInt();

        for (int i = M; i <= N; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
