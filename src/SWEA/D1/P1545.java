package SWEA.D1;

import java.util.Scanner;

public class P1545 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = number; i >= 0; i--) {
            System.out.printf("%d ", i);
        }
    }
}
