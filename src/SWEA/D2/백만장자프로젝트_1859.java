package SWEA.D2;

import java.util.Scanner;

public class 백만장자프로젝트_1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] dailyPrices = new int[N];
            for (int i = 0; i < N; i++) {
                dailyPrices[i] = sc.nextInt();
            }
            int maxPrice = dailyPrices[N - 1];
            long maxProfit = 0;
            for (int i = N - 2; i >= 0 ; i--) {
                int dailyPrice = dailyPrices[i];
                if (maxPrice < dailyPrice) {
                    maxPrice = dailyPrice;
                } else {
                    int dailyProfit = maxPrice - dailyPrice;
                    if (dailyProfit > 0) {
                        maxProfit += dailyProfit;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, maxProfit);
        }
    }
}
