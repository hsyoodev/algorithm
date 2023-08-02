package baekjoon.mathematics;

import java.util.Scanner;

public class 숫자의개수_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int sum = A*B*C;
        int[] answer = new int[10];
        while (sum != 0) {
            answer[sum % 10]++;
            sum /= 10;
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
