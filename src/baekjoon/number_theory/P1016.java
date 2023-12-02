package baekjoon.number_theory;

import java.util.Scanner;

public class P1016 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        boolean[] isNotNoNos = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long powI = i * i;
            for (long j = min / powI; powI * j <= max; j++) {
                long number = powI * j;
                if (number >= min) {
                    isNotNoNos[(int) (number - min)] = true;
                }
            }
        }
        int answer = 0;
        for (boolean isNotNoNo : isNotNoNos) {
            if (!isNotNoNo) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}
