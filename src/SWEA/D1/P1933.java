package SWEA.D1;

import java.util.Scanner;

public class P1933 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.printf("%d ", i);
            }
        }
    }
}
