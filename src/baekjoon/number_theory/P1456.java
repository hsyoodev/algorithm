package baekjoon.number_theory;

import java.util.Arrays;
import java.util.Scanner;

public class P1456 {

    private static boolean[] isPrimeNumbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        isPrimeNumbers = new boolean[10000001];
        Arrays.fill(isPrimeNumbers, true);
        eratos();
        int answer = 0;
        for (int i = 2; i < isPrimeNumbers.length; i++) {
            if (isPrimeNumbers[i]) {
                for (double j = (double) i * i; j <= B; j *= i) {
                    if (j >= A) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void eratos() {
        for (int i = 2; i * i < isPrimeNumbers.length; i++) {
            if (!isPrimeNumbers[i]) {
                continue;
            }
            for (int j = i * i; j < isPrimeNumbers.length; j += i) {
                isPrimeNumbers[j] = false;
            }
        }
    }
}
