package SWEA.D2;

import java.util.Scanner;

public class 패턴마디의길이_2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String pattern = sc.next();
            for (int i = 1; i * 2 < pattern.length(); i++) {
                String currentWord = pattern.substring(0, i);
                String nextWord = pattern.substring(i, i * 2);
                if (currentWord.equals(nextWord)) {
                    System.out.printf("#%d %d\n", test_case, currentWord.length());
                    break;
                }
            }
        }
    }
}
