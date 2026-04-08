package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707_이분_그래프 {

    private static ArrayList<Integer>[] graph;
    private static boolean[] isVisited;
    private static int[] check;
    private static boolean isExsist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            isVisited = new boolean[V + 1];
            check = new int[V + 1];
            isExsist = true;

            for (int j = 1; j < V + 1; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for (int j = 1; j < V + 1; j++) {
                if (isExsist) {
                    DFS(j);
                } else {
                    break;
                }
            }

            System.out.println(isExsist ? "YES" : "NO");
        }
    }

    private static void DFS(int node) {
        isVisited[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);

            if (!isVisited[nextNode]) {
                check[nextNode] = (check[node] + 1) % 2;
                DFS(nextNode);
            } else if (check[node] == check[nextNode]) {
                isExsist = false;
            }
        }
    }

}
