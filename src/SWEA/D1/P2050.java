package SWEA.D1;

import java.util.Scanner;

public class P2050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] alphabets = sc.next().toCharArray();
        for (char alphabet : alphabets) {
            System.out.printf("%d ", alphabet - '@');
        }
    }
}
