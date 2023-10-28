package baekjoon.binary_search;

import java.util.Scanner;

public class K번째수_1300 {

    static int N;
    static int K;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        binarySearch(1, K);
        System.out.print(answer);
    }

    static void binarySearch(int startValue, int endValue) {
        if (startValue > endValue) {
            return;
        }
        int centerValue = (startValue + endValue) / 2;
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            count += Math.min(centerValue / i, N);
        }
        if (count < K) {
            binarySearch(centerValue + 1, endValue);
        } else {
            answer = centerValue;
            binarySearch(startValue, centerValue - 1);
        }
    }
}