package baekjoon.gold;

import java.util.Scanner;

public class P2023_신기한_소수 {
    
    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();

        for (int i = 2; i < 10; i++) {
            if (isPrimeNumber(i)) {
                DFS(String.valueOf(i));
            }
        }
    }

    public static void DFS(String number) {
        if (!isPrimeNumber(Integer.parseInt(number))) {
            return;
        }

        if (number.length() == N) {
            System.out.println(number);

            return;
        }

        for (int i = 1; i < 10; i++) {
            DFS(number + i);
        }
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
