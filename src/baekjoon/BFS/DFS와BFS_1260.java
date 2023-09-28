package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS_1260 {
    static Queue<Integer>[] adjacencyList;
    static boolean[] visitied;

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        adjacencyList = new Queue[N + 1];
        visitied = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjacencyList[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjacencyList[node1].offer(node2);
            adjacencyList[node2].offer(node1);
        }
        DFS(V);
        System.out.println(answer);
        answer = new StringBuilder();
        visitied = new boolean[N + 1];
        BFS(V);
        System.out.println(answer);
    }

    static void DFS(int node) {
        visitied[node] = true;
        answer.append(node + " ");

        for (int adjacencyNode : adjacencyList[node]) {
            if (!visitied[adjacencyNode]) {
                DFS(adjacencyNode);
            }
        }
    }

    static void BFS(int node) {
        for (int adjacencyNode : adjacencyList[node]) {
            if (!visitied[adjacencyNode]) {
                visitied[adjacencyNode] = true;
                answer.append(adjacencyNode + " ");
            }
        }

        for (int adjacencyNode : adjacencyList[node]) {
            BFS(adjacencyNode);
        }
    }
}
