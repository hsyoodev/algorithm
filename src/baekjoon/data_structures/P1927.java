package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1927
public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 연산의 개수
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            // 연산에 대한 정보를 나타내는 정수
            int x = Integer.parseInt(bufferedReader.readLine());
            // x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거
            if (x == 0) {
                System.out.println(priorityQueue.isEmpty() ? 0 : priorityQueue.poll());
            }
            // x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고
            else {
                priorityQueue.offer(x);
            }
        }
    }
}
