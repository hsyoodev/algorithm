package baekjoon.silver;

import java.util.*;

public class P1325_효율적인_해킹 {

    private static ArrayList<Integer>[] graph;
    private static boolean[] isVisited;
    private static int[] reliabilities;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 컴퓨터 수
        int M = scanner.nextInt(); // 신뢰관계 수

        // 1.인접리스트, 신뢰도, 방문여부 생성하기
        graph = new ArrayList[N + 1];
        reliabilities = new int[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            graph[A].add(B);
        }

        // 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호 구하기
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(isVisited, false);
            BFS(i);
        }

        int max = Arrays.stream(reliabilities).max().getAsInt();

        for (int i = 1; i < N + 1; i++) {
            if (reliabilities[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            for (int i = 0; i < graph[nowNode].size(); i++) {
                int nextNode = graph[nowNode].get(i);

                if (!isVisited[nextNode]) {
                    queue.add(nextNode);
                    isVisited[nextNode] = true;
                    reliabilities[nextNode]++;
                }
            }
        }
    }

}
