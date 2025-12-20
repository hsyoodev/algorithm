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

        maxNode = new Node(1, 0);

        DFS(1, 0);

        Arrays.fill(isVisited, false);

        DFS(maxNode.number, 0);

        System.out.print(maxNode.distance);
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

        if (maxNode.distance < distance) {
            maxNode = new Node(number, distance);
        }
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
