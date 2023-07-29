package baekjoon.mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class 최소최대_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        System.out.print(A[0] + " " + A[N - 1]);
    }
}
