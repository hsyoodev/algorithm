package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/11286
public class P11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 연산의 개수
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x1, x2) -> {
            int absX1 = Math.abs(x1);
            int absX2 = Math.abs(x2);
            // 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수 우선순위
            if (absX1 == absX2) {
                return x1 - x2;
            }
            // 절댓값이 가장 작은 값 우선순위
            return absX1 - absX2;
        });
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bufferedReader.readLine());
            // x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우
            if (x == 0) {
                // 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
                // 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
                // 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력
                bufferedWriter.write(priorityQueue.isEmpty() ? "0" : String.valueOf(priorityQueue.poll()));
                bufferedWriter.newLine();
            }
            // 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산
            else {
                priorityQueue.offer(x);
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
