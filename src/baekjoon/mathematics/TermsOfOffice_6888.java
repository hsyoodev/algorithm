package baekjoon.mathematics;

import java.util.Scanner;

public class TermsOfOffice_6888 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        for (int i = X; i <= Y; i+=60) {
            System.out.println("All positions change in year " + i);
        }
    }
}
