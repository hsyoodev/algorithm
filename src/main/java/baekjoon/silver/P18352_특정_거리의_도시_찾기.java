package baekjoon.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P18352_특정_거리의_도시_찾기 {

    private static int[] visited;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 도시의 개수
        int M = scanner.nextInt(); // 도로의 개수
        int K = scanner.nextInt(); // 거리 정보
        int X = scanner.nextInt(); // 출발 도시의 번호

        // 1.인접리스트, 방문기록 생성하기
        graph = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            graph[A].add(B);
        }

        // 2.최단 거리 구하기
        BFS(X);

        // 3.정답 출력하기
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.print(-1);
        } else {
            answer.forEach(System.out::println);
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 0;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int i = 0; i < graph[nowNode].size(); i++) {
                int nextNode = graph[nowNode].get(i);

                if (visited[nextNode] == -1) {
                    queue.add(nextNode);
                    visited[nextNode] = visited[nowNode] + 1;
                }
            }
        }
    }

}
