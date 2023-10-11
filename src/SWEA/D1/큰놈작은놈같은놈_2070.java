package SWEA.D1;

import java.util.Scanner;

public class 큰놈작은놈같은놈_2070 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int number1 = sc.nextInt();
            int number2 = sc.nextInt();
            String answer = number1 == number2 ?
                    "=" : (number1 > number2 ? ">" : "<");
            System.out.printf("#%d %s\n", test_case, answer);
        }
    }
}
