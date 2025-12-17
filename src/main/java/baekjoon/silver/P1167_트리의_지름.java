package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1167_트리의_지름 {

    private static boolean[] isVisited;
    private static ArrayList<Node>[] graph;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        isVisited = new boolean[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());

            graph[number] = new ArrayList<>();

            while (true) {
                int a = Integer.parseInt(st.nextToken());

                if (a == -1) {
                    break;
                }

                int b = Integer.parseInt(st.nextToken());

                graph[number].add(new Node(a, b));
            }
        }

        for (int i = 1; i <= V; i++) {
            if (!isVisited[i]) {
                DFS(1, 0);

                Arrays.fill(isVisited, false);
            }
        }

        System.out.print(max);
    }

    private static void DFS(int number, int distance) {
        isVisited[number] = true;

        for (int i = 0; i < graph[number].size(); i++) {
            Node nextNode = graph[number].get(i);
            int sumDistance = distance + nextNode.distance;

            if (!isVisited[nextNode.number]) {
                DFS(nextNode.number, sumDistance);
            }
        }

        max = Math.max(distance, max);
    }

}

class Node {

    int number;
    int distance;

    public Node(int number, int distance) {
        this.number = number;
        this.distance = distance;
    }

}
