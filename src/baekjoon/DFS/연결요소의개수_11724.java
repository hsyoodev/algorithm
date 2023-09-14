package baekjoon.DFS;

import java.util.*;

public class 연결요소의개수_11724 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        if (M == 0) {
            System.out.print(0);
            return;
        }
        Queue<Integer>[] adjacencyList = new Queue[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < M; i++) {
            int currentPoint = scanner.nextInt();
            int adjacencyPoint = scanner.nextInt();
            if (i == 0) {
                visited[currentPoint] = true;
                stack.push(currentPoint);
            }
            adjacencyList[currentPoint].offer(adjacencyPoint);
        }
        int answer = 1;
        while (!stack.isEmpty()) {
            int currentPoint = stack.pop();
            while (!adjacencyList[currentPoint].isEmpty()) {
                int adjacencyPoint = adjacencyList[currentPoint].poll();
                if (!visited[adjacencyPoint]) {
                    stack.push(adjacencyPoint);
                    visited[adjacencyPoint] = true;
                } else {
                    boolean a = true;
                    for (int i = 1; i < N + 1; i++) {
                        if (!visited[i]) {
                            a = false;
                        }
                    }
                    if (a) {
                        answer++;
                    }
                }
            }
            if (stack.isEmpty()) {
                boolean a = true;
                for (int i = 1; i < N + 1; i++) {
                    if (!visited[i]) {
                        stack.push(i);
                        visited[i] = true;
                        a = false;
                        break;
                    }
                }
                if (a) {
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
