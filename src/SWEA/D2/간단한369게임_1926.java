package SWEA.D2;

import java.util.Scanner;

public class 간단한369게임_1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            int number = i;
            StringBuilder clapCount = new StringBuilder();
            boolean isClap = false;
            while (number != 0) {
                int remainder = number % 10;
                switch (remainder) {
                    case 3:
                    case 6:
                    case 9:
                        clapCount.append("-");
                        isClap = true;
                }
                number /= 10;
            }
            System.out.printf("%s ", isClap ? clapCount : i);
        }
    }
}
