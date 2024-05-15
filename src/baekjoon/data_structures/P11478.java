package baekjoon.data_structures;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.acmicpc.net/problem/11478
public class P11478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 첫째 줄에 문자열 S가 주어진다.
        String S = scanner.nextLine();
        // 부분 문자열 구하기
        Set<String> subS = new HashSet<>();
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 0; j + i <= S.length(); j++) {
                subS.add(S.substring(j, j + i));
            }
        }
        // 서로 다른 부분 문자열의 개수
        System.out.print(subS.size());
    }
}
