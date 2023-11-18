package SWEA;

import java.util.Scanner;

public class P1970 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] wons = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = scanner.nextInt();
            int[] counts = new int[8];
            for (int i = 0; i < wons.length; i++) {
                counts[i] = N / wons[i];
                if (counts[i] != 0) {
                    N %= wons[i];
                }
            }
            System.out.printf("#%d\n", testCase);
            for (int count : counts) {
                System.out.printf("%d ", count);
            }
            System.out.println();
        }
    }
}
