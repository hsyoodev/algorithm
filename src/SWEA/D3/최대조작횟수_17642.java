package SWEA.D3;

import java.util.Scanner;

public class 최대조작횟수_17642 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            long A = sc.nextLong();
            long B = sc.nextLong();
            long count = (A < (B - 1)) ? ((B - A) / 2) : (A == B ? 0 : -1);
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}
