package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2178_미로_탐색 {

    private static int[][] miro;
    private static boolean[][] isVisited;
    private static final int[][] directions = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
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

        BFS(0, 0);

        System.out.print(miro[N - 1][M - 1]);

        scanner.close();
    }

    private static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y});

        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] nowNode = queue.poll();
            int nowX = nowNode[0];
            int nowY = nowNode[1];

            for (int[] direction : directions) {
                int[] nextNode = {nowX + direction[0], nowY + direction[1]};
                int nextX = nextNode[0];
                int nextY = nextNode[1];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (miro[nextX][nextY] == 1 && !isVisited[nextX][nextY]) {
                        queue.add(nextNode);

                        isVisited[nextX][nextY] = true;

                        miro[nextX][nextY] = miro[nextX][nextY] + 1;
                    }
                }
            }
        }
    }

}
