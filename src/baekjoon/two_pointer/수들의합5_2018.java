package baekjoon.two_pointer;

import java.util.Scanner;

public class 수들의합5_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int sum = 0;
        int start = 1;
        for (int i = 1; i <= N; i++) {
            if (sum > N) {
                sum -= start++;
                i--;
                continue;
            } else if (sum == N){
                sum -= start++;
                count++;
            }
            sum += i;
        }
        System.out.print(count);
    }
}
