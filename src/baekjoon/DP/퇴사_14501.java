package baekjoon.DP;

import java.util.Scanner;

public class 퇴사_14501 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Counseling[] days = new Counseling[N + 1];
        for (int i = 1; i <= N; i++) {
            int duration = scanner.nextInt();
            int cost = scanner.nextInt();
            days[i] = new Counseling(duration, cost);
        }
        int maxProfit = 0;
        for (int i = 1; i <= N;) {
            int duration = days[i].duration;
            int cost = days[i].cost;
            if (i + duration - 1 <= N) {
                maxProfit += cost;
                for (int j = i + 1; j < i + duration; j++) {
                    if (j + duration - 1 <= i + duration - 1) {
                        if (cost < days[j].cost) {
                            i = j;
                            maxProfit += days[j].cost - cost;
                        }
                    }
                }
            }
            i += duration;
        }
        System.out.println(maxProfit);
    }
}

class Counseling {
    public int duration;
    public int cost;

    public Counseling(int duration, int cost) {
        this.duration = duration;
        this.cost = cost;
    }
}