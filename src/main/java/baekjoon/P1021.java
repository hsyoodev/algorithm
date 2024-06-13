package baekjoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

// https://www.acmicpc.net/problem/1021
public class P1021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 큐의 크기
        int N = scanner.nextInt();
        // 왼쪽으로 이동하는 큐
        Deque<Integer> leftDeque = new ArrayDeque<>();
        // 오른쪽으로 이동하는 큐
        Deque<Integer> rightDeque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            leftDeque.offer(i);
            rightDeque.offer(i);
        }
        // 뽑아내려고 하는 수의 개수
        int M = scanner.nextInt();
        int answer = 0;
        for (int i = 0; i < M; i++) {
            // 지민이가 뽑아내려고 하는 수의 위치
            int targetNumber = scanner.nextInt();
            // 왼쪽인 경우
            int left = 0;
            while (!leftDeque.isEmpty()) {
                int number = leftDeque.pollFirst();
                if (number == targetNumber) {
                    break;
                } else {
                    leftDeque.offerLast(number);
                    left++;
                }
            }
            // 오른쪽인 경우
            int right = 0;
            while (!rightDeque.isEmpty()) {
                int number = rightDeque.pollLast();
                rightDeque.offerFirst(number);
                right++;
                if (number == targetNumber) {
                    rightDeque.pollFirst();
                    break;
                }
            }
            // 왼쪽과 오른쪽 중에 최솟값을 찾는다.
            if (left > right) {
                answer += right;
                leftDeque.clear();
                leftDeque.addAll(rightDeque);
            } else {
                answer += left;
                rightDeque.clear();
                rightDeque.addAll(leftDeque);
            }
        }
        System.out.print(answer);
    }
}
