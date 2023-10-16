package SWEA.D3;

import java.util.Scanner;

public class 원안의점_16910 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int count = 0;
            for (int x = 0; x <= N; x++) {
                for (int y = 0; y * y <= N * N - x * x; y++) {
                    count+=1;
                }
            }
            System.out.printf("#%d %d\n", test_case, (count * 4 - 3 - 4 * N));
        }
    }
}
