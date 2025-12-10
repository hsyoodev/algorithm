package baekjoon.silver;

import java.util.*;

public class P1260_DFS와_BFS {

    private static boolean[] isVisited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int V = scanner.nextInt();

        isVisited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < graph.length; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }

        DFS(V);

        Arrays.fill(isVisited, false);
        System.out.println();

        BFS(V);

        scanner.close();
    }

    public static void DFS(int node) {
        isVisited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);

            if (!isVisited[nextNode]) {
                DFS(nextNode);
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();

        isVisited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            System.out.print(nowNode + " ");

            for (int i = 0; i < graph[nowNode].size(); i++) {
                int nextNode = graph[nowNode].get(i);

                if (!isVisited[nextNode]) {
                    isVisited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }

}
