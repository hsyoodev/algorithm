package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class P1984 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                numbers[i] = scanner.nextInt();
            }
            Arrays.sort(numbers);
            int sum = 0;
            for (int i = 1; i < 9; i++) {
                sum += numbers[i];
            }
            int average = (int) Math.round(sum / 8.0);
            System.out.printf("#%d %d\n", test_case, average);
        }
    }
}
