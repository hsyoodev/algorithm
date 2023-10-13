package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class 등차수열만들기_18662 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            double x1 = Math.abs((c + a - 2 * b) / 2.0);
            double x2 = Math.abs(c + a - 2 * b);
            double x3 = Math.abs(2 * b - c - a);
            double x = Arrays.stream(new double[]{x1, x2, x3}).min().getAsDouble();
            System.out.printf("#%d %.1f\n", test_case, x);
        }
    }
}
