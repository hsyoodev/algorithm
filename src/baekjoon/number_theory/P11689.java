package baekjoon.number_theory;

import java.util.Scanner;

public class P11689 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long temp = n;
        long answer = n;
        for (long i = 2; i * i <= n; i++) {
            while (temp % i == 0) {
                temp /= i;
                answer -= temp;
            }
        }
        if (temp != 1) {
            if (temp == answer) {
                answer -= (answer / temp);
            } else {
                answer += (answer / temp);
            }
        }
        System.out.print(answer);
    }
}
