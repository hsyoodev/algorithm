package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class 백만장자프로젝트_1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] dayOfPrice = new int[N];
            int[] dayOfProfit = new int[N - 1];
            for (int i = 0; i < N; i++) {
                dayOfPrice[i] = sc.nextInt();
            }

            int startDay = 0;
            int endDay = N - 1;
            while (startDay < endDay) {
                int startPrice = dayOfPrice[startDay];
                int endPrice = dayOfPrice[endDay];
                int profit = endPrice - startPrice;
                if (startPrice < endPrice) {
                    if (dayOfProfit[startDay] < profit) {
                        dayOfProfit[startDay] = profit;
                    }
                }
                endDay--;
            }
            int maxProfit = Arrays.stream(dayOfProfit).sum();
            System.out.printf("#%d %d\n", test_case, maxProfit);
        }
    }
}
