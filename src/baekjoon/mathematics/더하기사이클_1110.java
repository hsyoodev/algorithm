package baekjoon.mathematics;

import java.util.Scanner;

public class 더하기사이클_1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp = N;
        int count = 0;
        while (true) {
            int divide = temp / 10;
            int mod = temp % 10;
            temp = mod * 10 + (divide + mod) % 10;
            count++;
            if (N == temp) {
                break;
            }
        }
        System.out.print(count);
    }
}
