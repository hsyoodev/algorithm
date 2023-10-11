package SWEA.D1;

import java.util.Scanner;

public class 평균값구하기_2071 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += sc.nextInt();
            }
            int avg = Math.round(sum / (float) 10);
            System.out.printf("#%d %d\n", test_case, avg);
        }
    }
}
