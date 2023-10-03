package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        int vertexNumber = 1;
        BFS(vertexNumber);
        for (int i = 1; i < V + 1; i++) {
            if (distance[vertexNumber] < distance[i]) {
                vertexNumber = i;
            }
        }
        Arrays.fill(visited, false);
        BFS(vertexNumber);
        System.out.print(Arrays.stream(distance).max().getAsInt());
    }

    static void BFS(int vertexNumber) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(vertexNumber, 0));
        visited[vertexNumber] = true;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentVertexNumber = currentNode.vertexNumber;
            int currentDistance = currentNode.distance;
            distance[currentVertexNumber] = currentDistance;
            for (Node adjacencyNode : adjacencyList[currentVertexNumber]) {
                int adjacencyVertexNumber = adjacencyNode.vertexNumber;
                int adjacencyDistance = adjacencyNode.distance;
                if (!visited[adjacencyVertexNumber]) {
                    queue.offer(new Node(adjacencyVertexNumber, adjacencyDistance + currentDistance));
                    visited[adjacencyVertexNumber] = true;
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
