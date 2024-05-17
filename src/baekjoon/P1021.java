package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1021
public class P1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 큐의 크기
        int N = Integer.parseInt(stringTokenizer.nextToken());
        Deque<Integer> leftDeque = new ArrayDeque<>();
        Deque<Integer> rightDeque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            leftDeque.offer(i);
            rightDeque.offer(i);
        }
        // 뽑아내려고 하는 수의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int answer = 0;
        // 지민이가 뽑아내려고 하는 수의 위치
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            int left = 0;
            int right = 0;
            // 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
            while (!leftDeque.isEmpty()) {
                int pollNumber = leftDeque.pollFirst();
                if (number == pollNumber) {
                    break;
                }
                leftDeque.offerLast(pollNumber);
                left++;
            }
            // 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
            while (!rightDeque.isEmpty()) {
                right++;
                int pollNumber = rightDeque.pollLast();
                if (number == pollNumber) {
                    break;
                }
                rightDeque.offerFirst(pollNumber);
            }
            // 2번, 3번 연산의 최솟값
            if (left <= right) {
                rightDeque.clear();
                rightDeque.addAll(leftDeque);
            } else {
                leftDeque.clear();
                leftDeque.addAll(rightDeque);
            }
            answer += Math.min(left, right);
        }
        System.out.print(answer);
    }
}
