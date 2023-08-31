package baekjoon.mathematics;

import java.util.Scanner;

public class ISBN_6810 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ISBN = "9780921418";
        for (int i = 0; i < 3; i++) {
            ISBN += scanner.nextLine();
        }
        int sum = 0;
        for (int i = 0; i < ISBN.length(); i++) {
            sum += (ISBN.charAt(i) - '0') * (i % 2 == 0 ? 1 : 3);
        }
        System.out.print("The 1-3-sum is " + sum);
    }
}
