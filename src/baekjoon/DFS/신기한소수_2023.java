package baekjoon.DFS;

import java.util.Scanner;

public class 신기한소수_2023 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int endNumber = (int) Math.pow(10, N) - 1;
        int startNumber = (endNumber + 1) / 5;
        for (int i = startNumber; i <=  endNumber; i++) {
            if (isPrimeNumber(i)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isPrimeNumber(int number){
        if (number == 0) {
            return true;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return isPrimeNumber(number / 10);
    }
}
