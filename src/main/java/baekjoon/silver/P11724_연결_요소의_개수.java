package baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class P11724_연결_요소의_개수 {

    private static ArrayList<Integer>[] nodes;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 정점의 개수
        int M = scanner.nextInt(); // 간선의 개수
        nodes = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            nodes[u].add(v);
            nodes[v].add(u);
        }

        for (int i = 1; i <= nodes.length - 1; i++) {
            if (!visited[i]) {
                DFS(i);

                answer++;
            }
        }

        System.out.print(answer);

        scanner.close();
    }

    public static void DFS(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int i = 0; i < nodes[node].size(); i++) {
            DFS(nodes[node].get(i));
        }
    }

}
