package baekjoon.number_theory;

import java.util.Arrays;
import java.util.Scanner;

public class P1456 {

    private static long A;
    private static long B;
    private static boolean[] isPrimeNumbers = new boolean[100000001];
    private static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextLong();
        B = scanner.nextLong();
        eratos();
        for (int i = 2; i < 10000001; i++) {
            if (isPrimeNumbers[i]) {
                for (long j = (long) i * i; j <= B; j *= i) {
                    if (j >= A) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void eratos() {
        Arrays.fill(isPrimeNumbers, true);
        for (int i = 2; i * i <= 10000000; i++) {
            if (!isPrimeNumbers[i]) {
                continue;
            }
            for (int j = i * i; j <= 10000000; j += i) {
                isPrimeNumbers[j] = false;
            }
        }
    }
}
