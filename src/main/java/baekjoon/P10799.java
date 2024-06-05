package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10799
public class P10799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] brackets = scanner.nextLine().split("");
        int bar = 0;
        int answer = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i].equals("(")) {
                bar++;
            } else {
                bar--;
                // 레이저인 경우에 쇠막대기 개수를 더하고
                // 쇠막대기 오른쪽 끝인 경우에 1을 더한다.
                answer += brackets[i - 1].equals("(") ? bar : 1;
            }
        }
        System.out.print(answer);
    }
}
