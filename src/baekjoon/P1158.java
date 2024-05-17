package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1158
public class P1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N명의 사람
        int N = scanner.nextInt();
        // 양의 정수 K
        int K = scanner.nextInt();
        // N명의 사람이 원을 이루면서 앉아있고
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }
        ArrayList<String> answer = new ArrayList<>();
        int count = 1;
        // N명의 사람이 모두 제거될 때까지
        while (!numbers.isEmpty()) {
            // 순서대로 K번째 사람을 제거
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numbers.size(); i++, count++) {
                if (count == K) {
                    answer.add(String.valueOf(numbers.get(i)));
                    count = 0;
                    continue;
                }
                temp.add(numbers.get(i));
            }
            numbers = temp;
        }
        // (N, K)-요세푸스 순열
        System.out.print("<" + String.join(", ", answer) + ">");
    }
}
