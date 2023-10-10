package baekjoon.binary_search;

import java.util.Scanner;

public class K번째수_1300 {
    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        binarySearchX(1, N);
    }

    static void binarySearchX(int x1, int x2) {
        int midX = (x1 + x2) / 2;
        int prevX = midX - 1;
        int nextX = midX + 1;
        int minCount = (N * 2 * prevX) - (prevX * prevX) + 1;
        int maxCount = minCount - 1 + (N - midX + 1) * 2 - 1;
        if (K > maxCount) {
            binarySearchX(nextX, x2);
        } else if (K < minCount) {
            binarySearchX(x1, prevX);
        } else {
            int count = minCount;
            for (int i = midX; i <= N; i++) {
                if (K <= count) {
                    System.out.print(midX * i);
                    break;
                }
                count += 2;
            }
        }
    }
}