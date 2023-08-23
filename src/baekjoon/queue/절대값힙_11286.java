package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 연산의 개수 N
        int N = Integer.parseInt(br.readLine());
        // 절댓값 힙 연산을 지원하는 priorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            return absX == absY ? (x - y) : (absX - absY);
        });
        // 절대값 힙 연산
        for (int i = 0; i < N; i++) {
            // 연산에 대한 정보 x
            int x = Integer.parseInt(br.readLine());
            // x가 0이라면
            if (x == 0) {
                // 빈 배열이면 x 출력
                // 빈 배열이 아니면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
                System.out.println((int) (priorityQueue.isEmpty() ? x : priorityQueue.poll()));
                continue;
            }
            // x가 0이아니라면 배열에 x라는 값을 넣는다.
            priorityQueue.offer(x);
        }
    }
}
