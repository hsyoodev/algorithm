package baekjoon.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class P13023_ABCDE {

    private static boolean[] isVisited;
    private static ArrayList<Integer>[] graph;
    private static boolean isExist = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        isVisited = new boolean[N];
        graph = new ArrayList[N];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                DFS(i, 0);

                isVisited[i] = false;
            }

            if (isExist) {
                System.out.print(1);

                return;
            }
        }

        System.out.print(0);
    }

    public static void DFS(int node, int depth) {
        if (depth == 4) {
            isExist = true;

            return;
        }

        isVisited[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);
            
            if (!isVisited[nextNode]) {
                DFS(nextNode, depth + 1);

                isVisited[nextNode] = false;
            }
        }
    }

}
