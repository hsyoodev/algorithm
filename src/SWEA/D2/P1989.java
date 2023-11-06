package SWEA.D2;

import java.util.Scanner;

public class P1989 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            String word = scanner.next();
            String[] splitWord = word.split("");
            StringBuilder flipWord = new StringBuilder();
            for (int i = splitWord.length - 1; i >= 0; i--) {
                flipWord.append(splitWord[i]);
            }
            boolean isPalindrome = word.contentEquals(flipWord);
            System.out.printf("#%d %d\n", test_case, isPalindrome ? 1 : 0);
        }
    }
}
