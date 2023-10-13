package SWEA.D1;

import java.util.Scanner;

public class 자릿수더하기_2058 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (char number : sc.next().toCharArray()) {
            sum += number - '0';
        }
        System.out.print(sum);
    }
}
