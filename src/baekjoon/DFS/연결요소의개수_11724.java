package baekjoon.DFS;

import java.util.*;

public class 연결요소의개수_11724 {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        adjacencyList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }
        visited = new boolean[N + 1];
        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                answer++;
                DFS(i);
            }
        }
        System.out.print(answer);
    }
    static void DFS(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int adjacencyNode : adjacencyList[node]) {
            if (!visited[adjacencyNode]) {
                DFS(adjacencyNode);
            }
        }
    }
}
