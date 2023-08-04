package baekjoon.mathematics;

import java.util.Scanner;

public class GCD1_11689 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            if (A[i] == i) {
                if ()
                for (int j = i; j <= n; j += i) {
                    A[j] -= (A[j] / i);
                }
            }
        }
//        for (int i = 2; i <= n; i++) {
//            if (n % i == 0) {
//                n -= (n / i);
//            }
//        }
        System.out.print(A[n]);
    }
}
