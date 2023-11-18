package baekjoon.number_theory;

import java.util.Scanner;

public class P1747 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        while (true) {
            if (!isPrimeNumber(N)) {
                N++;
                continue;
            }
            if (!isPalindrome(String.valueOf(N))) {
                N++;
                continue;
            }
            System.out.print(N);
            break;
        }
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return number != 1;
    }

    private static boolean isPalindrome(String number) {
        StringBuilder flipNumber = new StringBuilder();
        for (int i = number.length() - 1; i >= 0; i--) {
            flipNumber.append(number.charAt(i));
        }
        return number.contentEquals(flipNumber);
    }
}
