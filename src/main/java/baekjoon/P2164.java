package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2164
public class P2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        // 정수
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        // 카드가 한 장 남을 때까지 반복하게 된다.
        while (queue.size() > 1) {
            // 제일 위에 있는 카드를 바닥에 버린다.
            queue.poll();
            // 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
            int number = queue.poll();
            queue.offer(number);
        }
        System.out.print(queue.poll());
        scanner.close();
    }
}
