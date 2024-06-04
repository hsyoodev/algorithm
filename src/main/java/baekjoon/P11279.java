package baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/11279
public class P11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 연산의 개수
        int N = Integer.parseInt(bufferedReader.readLine());
        // 최대 힙
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(bufferedReader.readLine());
            if (x == 0) {
                // 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
                // 만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력
                bufferedWriter.write(priorityQueue.isEmpty() ? "0" : String.valueOf(priorityQueue.poll()));
                bufferedWriter.newLine();
            } else {
                // 배열에 자연수 x를 넣는다.
                priorityQueue.offer(x);
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
