package SWEA.D1;

import java.util.Scanner;

public class 홀수만더하기_2072 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int number = sc.nextInt();
                if ((number & 1) == 1) {
                    sum += number;
                }
            }
            System.out.printf("#%d %d\n", test_case, sum);
        }
    }
}
