package baekjoon.two_pointer;

import java.util.Scanner;

public class 수들의합5_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 1;
        int startIndex = 1;
        int endIndex = 2;
        int maxIndex = (N / 2) + (N % 2);
        int sum = startIndex + endIndex;
        while (endIndex <= maxIndex) {
            if (sum == N) {
                answer++;
                sum += (++endIndex - startIndex++);
            } else if (sum < N) {
                sum += ++endIndex;
            } else {
                sum -= startIndex++;
            }
        }
        System.out.print(answer);
    }
}
