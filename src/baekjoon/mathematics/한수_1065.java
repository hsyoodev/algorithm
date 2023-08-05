package baekjoon.mathematics;

import java.util.Scanner;

public class 한수_1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = N;
        for (int i = 100; i <= N; i++) {
            String[] S = String.valueOf(i).split("");
            int a = Integer.parseInt(S[0]);
            int d = Integer.parseInt(S[1]) - Integer.parseInt(S[0]);
            for (int j = 0; j < S.length; j++) {
                if (Integer.parseInt(S[j]) != (a + j * d)) {
                    answer--;
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}
