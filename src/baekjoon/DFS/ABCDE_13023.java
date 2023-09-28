package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ABCDE_13023 {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visited;
    static boolean arrived = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrived) {
                break;
            }
        }
        System.out.print(arrived ? 1 : 0);
    }

    static void DFS(int node, int depth) {
        if (depth == 5 || arrived) {
            arrived = true;
            return;
        }
        visited[node] = true;
        for (int adjacencyNode : adjacencyList[node]) {
            if (!visited[adjacencyNode]) {
                DFS(adjacencyNode, depth + 1);
            }
        }
        visited[node] = false;
    }
}
