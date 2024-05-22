package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10816
public class P10816 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        // 숫자 카드의 개수
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        // 몇 개 가지고 있는 숫자 카드인지 구해야하는 횟수
        int M = scanner.nextInt();
        for (int i = 0; i < M; i++) {
            stringBuilder.append(map.getOrDefault(scanner.nextInt(), 0)).append(" ");
        }
        System.out.print(stringBuilder);
        scanner.close();
    }
}
