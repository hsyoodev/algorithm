package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1158
public class P1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> persons = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        // 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고,
        for (int i = 1; i <= N; i++) {
            persons.offer(i);
        }
        stringBuilder.append("<");
        int number = 0;
        // N - 1명의 사람이 모두 제거될 때까지 계속
        while (persons.size() > 1) {
            int person = persons.poll();
            number++;
            // K번째 사람을 제거한다.
            if (number == K) {
                stringBuilder.append(person);
                stringBuilder.append(", ");
                number = 0;
            } else {
                persons.offer(person);
            }
        }
        stringBuilder.append(persons.poll());
        stringBuilder.append(">");
        System.out.print(stringBuilder);
    }
}
