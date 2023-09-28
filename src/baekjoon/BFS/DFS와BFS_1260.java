package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS_1260 {
    static List<Integer>[] adjacencyList;
    static boolean[] visitied;

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adjacencyList[i]);
        }
        visitied = new boolean[N + 1];
        DFS(V);
        Arrays.fill(visitied, false);
        answer.append("\n");
        BFS(V);
        System.out.print(answer);
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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visitied[node] = true;
        while (!queue.isEmpty()) {
            int visitedNode = queue.poll();
            answer.append(visitedNode + " ");
            for (int adjacencyNode : adjacencyList[visitedNode]) {
                if (!visitied[adjacencyNode]) {
                    visitied[adjacencyNode] = true;
                    queue.add(adjacencyNode);
                }
            }
        }
    }
}
