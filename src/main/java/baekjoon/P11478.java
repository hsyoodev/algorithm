package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.acmicpc.net/problem/11478
public class P11478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        // 서로 다른 부분 문자열 구하기
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j + i <= S.length(); j++) {
                set.add(S.substring(j, j + i));
            }
        }
        System.out.print(set.size());
    }
}
