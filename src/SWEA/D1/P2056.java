package SWEA.D1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class P2056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String date = sc.next();
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));
            String answer = "-1";
            if(isValidateDate(month, day)) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate localDate = LocalDate.of(year, month, day);
                answer = localDate.format(dateTimeFormatter);
            }
            System.out.printf("#%d %s\n", test_case, answer);
        }
    }

    private static boolean isValidateDate(int month, int day) {
        boolean isValidateDate = true;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    isValidateDate = false;
                }
                break;
            case 2:
                if (day > 28) {
                    isValidateDate = false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    isValidateDate = false;
                }
                break;
            default:
                isValidateDate = false;
        }
        return isValidateDate;
    }
}
