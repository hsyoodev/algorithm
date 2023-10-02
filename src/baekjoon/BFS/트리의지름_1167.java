package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의지름_1167 {
    static ArrayList<Node>[] adjacencyList;
    static boolean[] visited;
    static int treeDiameter;

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
                adjacencyList[node1].add(new Node(node2, distance));
                adjacencyList[node2].add(new Node(node1, distance));
            }
        }
        BFS(1);
        System.out.print(treeDiameter);
    }

    static void BFS(int vertexNumber) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(vertexNumber, 0));
        visited[vertexNumber] = true;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node adjacencyNode : adjacencyList[currentNode.vertexNumber]) {
                if (!visited[adjacencyNode.vertexNumber]) {
                    queue.offer(adjacencyNode);
                    visited[adjacencyNode.vertexNumber] = true;
                }
            }
        }
    }
}

class Node {
    int vertexNumber;
    int distance;

    public Node(int vertexNumber, int distance) {
        this.vertexNumber = vertexNumber;
        this.distance = distance;
    }
}
