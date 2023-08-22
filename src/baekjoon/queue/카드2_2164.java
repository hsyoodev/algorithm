package baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 카드 개수 N
        int N = sc.nextInt();
        // 1 ~ N까지의 번호 queue
        Queue<Integer> queue = new LinkedList<>();
        // queue 초기화
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        // 카드가 한 장 남을 때까지 반복
        while (queue.size() != 1) {
            // 제일 위에 있는 카드를 바닥에 버린다.
            queue.poll();
            // 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
            queue.offer(queue.poll());
        }
        System.out.print(queue.peek());
    }
}
