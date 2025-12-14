package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178_미로_탐색 {

    private static int[][] miro;
    private static boolean[][] isVisited;
    private static final int[][] points = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        miro = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] number = scanner.next().split("");

            for (int j = 0; j < number.length; j++) {
                miro[i][j] = Integer.parseInt(number[j]);
            }
        }

        BFS(new int[]{0, 0});

        System.out.print(miro[N - 1][M - 1]);

        scanner.close();
    }

    private static void BFS(int[] node) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.add(node);

        isVisited[node[0]][node[1]] = true;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();

            for (int[] point : points) {
                int[] nextNode = {nowNode[0] + point[0], nowNode[1] + point[1]};

                if (nextNode[0] >= 0 && nextNode[0] < N && nextNode[1] >= 0 && nextNode[1] < M) {
                    if (miro[nextNode[0]][nextNode[1]] == 1) {
                        if (!isVisited[nextNode[0]][nextNode[1]]) {
                            queue.add(nextNode);

                            isVisited[nextNode[0]][nextNode[1]] = true;

                            miro[nextNode[0]][nextNode[1]] = miro[nowNode[0]][nowNode[1]] + 1;
                        }
                    }
                }
            }
        }
    }

}
