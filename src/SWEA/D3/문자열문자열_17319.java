package SWEA.D3;

import java.util.Scanner;

public class 문자열문자열_17319 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            String S = sc.next();
            String answer = "No";
            if (N % 2 == 0) {
                String word = S.substring(0, N / 2);
                if (S.equals(word + word)) {
                    answer = "Yes";
                }
            }
            System.out.printf("#%d %s\n", test_case, answer);
        }
    }
}
