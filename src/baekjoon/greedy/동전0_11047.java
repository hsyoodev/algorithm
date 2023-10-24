package baekjoon.greedy;

import java.util.Scanner;

public class 동전0_11047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coinValue = new int[N];
        for (int i = 0; i < N; i++) {
            coinValue[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (coinValue[i] <= K) {
                count += K / coinValue[i];
                K %= coinValue[i];
            }
        }
        System.out.print(count);
    }
}
