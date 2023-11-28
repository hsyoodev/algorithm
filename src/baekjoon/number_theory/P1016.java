package baekjoon.number_theory;

import java.util.Scanner;

public class P1016 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        int sqrtMax = (int) Math.sqrt(max);
        int notNoNoCount = 0;
        for (int i = 2; i <= sqrtMax; i++) {
            if (isPrimeNumber(i)) {
                double powI = Math.pow(i, 2);
                if (min <= powI) {
                    notNoNoCount += (int) (max / powI);
                    System.out.printf("%s %d\n", powI, (int) (max / powI));
                }
            }
        }
        long answer = max - min + 1 - notNoNoCount;
        System.out.print(answer);
    }
}
