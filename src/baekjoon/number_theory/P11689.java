package baekjoon.number_theory;

import java.util.Scanner;

public class P11689 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                result -= (result / i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            result -= (result / n);
        }
        System.out.print(result);
    }
}
