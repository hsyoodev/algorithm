package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절대값힙_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> {
            int absX = Math.abs(x);
            int absY = Math.abs(y);
            return absX == absY ? (x - y) : (absX - absY);
        });
        StringBuilder answer = new StringBuilder("");
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                answer.append((priorityQueue.isEmpty() ? x : priorityQueue.poll()) + "\n");
            } else {
                priorityQueue.offer(x);
            }
        }
        System.out.println(answer);
    }
}
