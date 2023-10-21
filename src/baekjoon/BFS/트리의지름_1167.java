package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의지름_1167 {

    static ArrayList<Node>[] adjacencyList;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        adjacencyList = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
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
        int vertex = 1;
        BFS(vertex);
        for (int i = 1; i < V + 1; i++) {
            if (distance[vertex] < distance[i]) {
                vertex = i;
            }
        }
        Arrays.fill(visited, false);
        BFS(vertex);
        int diameter = Arrays.stream(distance).max().getAsInt();
        System.out.print(diameter);
    }

    static void BFS(int vertex) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(vertex, 0));
        visited[vertex] = true;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentVertex = currentNode.vertex;
            int currentDistance = currentNode.distance;
            distance[currentVertex] = currentDistance;
            for (Node adjacencyNode : adjacencyList[currentVertex]) {
                int adjacencyVertex = adjacencyNode.vertex;
                int adjacencyDistance = adjacencyNode.distance;
                if (!visited[adjacencyVertex]) {
                    queue.offer(new Node(adjacencyVertex, adjacencyDistance + currentDistance));
                    visited[adjacencyVertex] = true;
                }
            }
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
