package baekjoon.DFS;

import java.util.Scanner;

public class 신기한소수_2023 {
    private static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        printAmazingPrimeNumber(2, 1);
        printAmazingPrimeNumber(3, 1);
        printAmazingPrimeNumber(5, 1);
        printAmazingPrimeNumber(7, 1);
    }
    private static void printAmazingPrimeNumber(int number, int digit) {
        if (digit == N) {
            System.out.println(number);
            return;
        }
        for (int i = 1; i < 10; i += 2) {
            if (isPrimeNumber(number * 10 + i)) {
                printAmazingPrimeNumber(number * 10 + i, digit + 1);
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
