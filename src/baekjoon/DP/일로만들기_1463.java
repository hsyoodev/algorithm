package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class 일로만들기_1463 {
    static int[] m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        m = new int[N + 1];
        Arrays.fill(m, -1);
        m[1] = 0;
        DP(N);
        System.out.print(m[N]);
    }

    static void DP(int X) {
        if (m[X] == -1) {
            int x = X;
            if (X % 3 == 0) {
                x = X / 3;
            } else if ((X - 1) % 3 == 0) {
                x = X - 1;
            } else if (X % 2 == 0) {
                x = X / 2;
            } else {
                x = X - 1;
            }
            System.out.println(x);
            DP(x);
            m[X] = 1 + m[x];
        }
    }
}
