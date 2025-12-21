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
    private static Node maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        isVisited = new boolean[V + 1];
        graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nowVertex = Integer.parseInt(st.nextToken());

            graph[nowVertex] = new ArrayList<>();

            while (true) {
                int nextVertex = Integer.parseInt(st.nextToken());

                if (nextVertex == -1) {
                    break;
                }

                int distance = Integer.parseInt(st.nextToken());

                graph[nowVertex].add(new Node(nextVertex, distance));
            }
        }

        maxNode = new Node(1, 0);

        DFS(1, 0);

        Arrays.fill(isVisited, false);

        DFS(maxNode.vertex, 0);

        System.out.print(maxNode.distance);
    }

    private static void DFS(int number, int distance) {
        isVisited[number] = true;

        for (int i = 0; i < graph[number].size(); i++) {
            Node nextNode = graph[number].get(i);

            if (!isVisited[nextNode.vertex]) {
                DFS(nextNode.vertex, distance + nextNode.distance);
            }
        }

        if (maxNode.distance < distance) {
            maxNode = new Node(number, distance);
        }
    }

}

class Node {

    int vertex;
    int distance;

    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

}
