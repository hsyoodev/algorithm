package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class P1966 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = scanner.nextInt();
            }
            Arrays.sort(numbers);
            System.out.printf("#%d ", testCase);
            Arrays.stream(numbers).forEach((number) -> System.out.printf("%d ", number));
            System.out.println();
        }
    }
}
