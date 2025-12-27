package baekjoon.gold;

import java.util.Scanner;

public class P1300_K번째_수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int k = scanner.nextInt();
        long start = 1;
        long end = k;
        long answer = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(middle / i, N);
            }

            if (count < k) {
                start = middle + 1;
            } else {
                end = middle - 1;
                answer = middle;
            }
        }

        System.out.print(answer);
    }

}
