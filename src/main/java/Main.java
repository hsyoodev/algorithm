import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static ArrayList<Integer>[] graph;
    private static boolean[] isVisited;
    private static boolean isExist = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        graph = new ArrayList[N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if (isExist) {
                break;
            }

            Arrays.fill(isVisited, false);
        }

        System.out.print(isExist ? 1 : 0);
    }

    private static void DFS(int node, int depth) {
        if (depth == 5) {
            isExist = true;

            return;
        }

        isVisited[node] = true;

        for (int i = 0; i < graph[node].size(); i++) {
            int nextNode = graph[node].get(i);

            if (!isVisited[nextNode]) {
                DFS(nextNode, depth + 1);

                isVisited[nextNode] = false;
            }
        }
    }

}
