package baekjoon.mathematics;

import java.util.Scanner;

public class 숫자의합_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.print(sc.next().chars().map(i -> i - '0').sum());
    }
}
