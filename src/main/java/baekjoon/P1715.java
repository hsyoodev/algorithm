package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1715
public class P1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 숫자 카드의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        // 숫자 카드 묶음의 각각의 크기가 주어진다.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(bufferedReader.readLine()));
        }
        // 두 묶음을 합쳐서 하나로 만드는 데
        int sum = 0;
        // 최소한 몇 번의 비교가 필요한지
        int answer = 0;
        while (priorityQueue.size() > 1) {
            sum = priorityQueue.poll() + priorityQueue.poll();
            // 합친 뒤 다시 넣어준다.
            if (!priorityQueue.isEmpty()) {
                priorityQueue.offer(sum);
            }
            answer += sum;
        }
        System.out.print(answer);
    }
}
