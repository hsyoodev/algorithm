package SWEA.D2;

import java.util.Scanner;

public class P1986 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = scanner.nextInt();
            int sum = 0;
            for (int number = 1; number <= N; number++) {
                sum += number * (isEven(number) ? -1 : 1);
            }
            System.out.printf("#%d %d\n", test_case, sum);
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
