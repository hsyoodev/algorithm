package baekjoon.data_structure;

import java.util.Scanner;

public class P9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int count = 0;
            for (char parenthesis : scanner.next().toCharArray()) {
                if (count == 0 && parenthesis == ')') {
                    count = -1;
                    break;
                }
                count += (parenthesis == '(' ? 1 : -1);
            }
            System.out.println(count == 0 ? "YES" : "NO");
        }
    }
}
