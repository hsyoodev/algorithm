package SWEA.D3;

import java.util.Scanner;

public class P16800 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            long N = sc.nextLong();
            int startX = 1;
            int startY = 1;
            long minDistance = N - startY;
            for (long endX = 1; endX * endX <= N; endX++) {
                if (N % endX == 0) {
                    long endY = N / endX;
                    long distance = endX - startX + endY - startY;
                    if (minDistance > distance) {
                        minDistance = distance;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, minDistance);
        }
    }
}
