package baekjoon.DFS;

import java.util.*;

public class 연결요소의개수_11724 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Queue<Integer>[] adjacencyList = new Queue[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        for (int i = 0; i < M; i++) {
            int node = scanner.nextInt();
            int adjacencyPoint = scanner.nextInt();
            adjacencyList[node].offer(adjacencyPoint);
            adjacencyList[adjacencyPoint].offer(node);
        }
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                answer++;
                stack.push(i);
                visited[i] = true;
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    while (!adjacencyList[node].isEmpty()) {
                        int adjacencyPoint = adjacencyList[node].poll();
                        if (!visited[adjacencyPoint]) {
                            stack.push(adjacencyPoint);
                            visited[adjacencyPoint] = true;
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
