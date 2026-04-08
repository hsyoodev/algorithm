package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707_이분_그래프 {

    private static ArrayList<Integer>[] graph;
    private static String[] visited;
    private static boolean isExsist = true;
    private static String set = "A";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];

            for (int j = 1; j < V + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
            }

            for (int j = 1; j < V + 1; j++) {
                visited = new String[V + 1];
                DFS(j);

                if (!isExsist) {
                    break;
                }
            }

            System.out.println(isExsist ? "YES" : "NO");
        }
    }

    private static void DFS(int node) {
        visited[node] = set;

        if (set.equals("A")) {
            set = "B";
        } else {
            set = "A";
        }

        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);

            if (visited[nextNode] == null) {
                DFS(nextNode);
            } else if (visited[node] == visited[nextNode]) {
                isExsist = false;
            }
        }
    }

}
