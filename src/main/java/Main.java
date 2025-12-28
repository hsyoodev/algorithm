import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int answer = 0;

        graph = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                DFS(i);

                answer++;
            }
        }

        System.out.print(answer);
    }

    private static void DFS(int node) {
        isVisited[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);

            if (!isVisited[nextNode]) {
                DFS(nextNode);
            }
        }
    }

}
