package baekjoon.silver;

import java.util.*;

public class P18352_특정_거리의_도시_찾기 {

    private static int K;
    private static boolean[] isVisited;
    private static ArrayList<Node>[] graph;
    private static final ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        K = scanner.nextInt();
        int X = scanner.nextInt();
        graph = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            graph[A].add(new Node(B, 0));
        }

        BFS(X);

        Collections.sort(answer);

        if (answer.isEmpty()) {
            System.out.print(-1);
        } else {
            answer.forEach(System.out::println);
        }

    }

    private static void BFS(int vertex) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(vertex, 0));
        isVisited[vertex] = true;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.distance == K) {
                answer.add(currentNode.vertex);
            }

            for (int i = 0; i < graph[currentNode.vertex].size(); i++) {
                Node nextNode = graph[currentNode.vertex].get(i);

                if (!isVisited[nextNode.vertex]) {
                    nextNode.distance = currentNode.distance + 1;
                    queue.add(nextNode);
                    isVisited[nextNode.vertex] = true;
                }
            }
        }
    }

    private static class Node {

        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

    }

}
