package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름_1167 {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visited;
    static long treeDiameter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        adjacencyList = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            while (true) {
                int node2 = Integer.parseInt(st.nextToken());
                if (node2 == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                adjacencyList[node1].add(node2);
                adjacencyList[node1].add(distance);
                adjacencyList[node2].add(node1);
                adjacencyList[node2].add(distance);
            }
        }
        long max = 0;
        for (int i = 1; i < V + 1; i++) {
            int a = DFS(i, 0);
            if (max < a) {
                max = a;
            }
        }
        System.out.print(max);
    }
    static int DFS(int node, int distance) {
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;
        int max = 0;
        for (int i = 0; i < adjacencyList[node].size(); i+=2) {
            if (!visited[adjacencyList[node].get(i)]) {
                int a = DFS(adjacencyList[node].get(i),adjacencyList[node].get(i + 1));
                if (max < a) {
                    max = a;
                }
            }
        }
        visited[node] = false;
        max += distance;
        return max;
    }
}

//    static void BFS(int node) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(node);
//        visited[node] = true;
//        while (!queue.isEmpty()) {
//            int adjacencyNode = queue.poll();
//            long max = 0;
//            for (int i = 0; i < adjacencyList[adjacencyNode].size(); i+=2) {
//                if (!visited[adjacencyList[adjacencyNode].get(i)]) {
//                    queue.offer(adjacencyList[adjacencyNode].get(i));
//                    visited[adjacencyList[adjacencyNode].get(i)] = true;
//                    if (max < adjacencyList[adjacencyNode].get(i + 1)) {
//                        max = adjacencyList[adjacencyNode].get(i + 1);
//                    }
//                }
//            }
//            treeDiameter += max;
//        }
//    }
