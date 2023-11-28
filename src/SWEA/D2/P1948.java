package SWEA.D2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class P1948 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int startMonth = scanner.nextInt();
            int startDay = scanner.nextInt();
            int endMonth = scanner.nextInt();
            int endDay = scanner.nextInt();
            LocalDate startDate = LocalDate.of(2023, startMonth, startDay);
            LocalDate endDate = LocalDate.of(2023, endMonth, endDay);
            long diffDay = startDate.until(endDate, ChronoUnit.DAYS) + 1;
            System.out.printf("#%d %d\n", testCase, diffDay);
        }
    }
}
