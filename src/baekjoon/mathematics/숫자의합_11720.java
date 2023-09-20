package baekjoon.mathematics;

import java.util.Scanner;

public class 숫자의합_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int sum = scanner.next().chars()
                .map(i -> i - '0')
                .sum();
        System.out.print(sum);
    }
}
