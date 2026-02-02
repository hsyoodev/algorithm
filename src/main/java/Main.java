import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int N;
    private static int M;
    private static int[][] miro;
    private static boolean[][] isVisited;
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        miro = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String st = scanner.next();

            for (int j = 0; j < M; j++) {
                miro[i][j] = Character.getNumericValue(st.charAt(j));
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
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int[] direction = directions[i];
                int nextX = node[0] + direction[0];
                int nextY = node[1] + direction[1];

                if (nextX > -1 && nextX < N && nextY > -1 && nextY < M) {
                    if (miro[nextX][nextY] == 1 && !isVisited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;

                        miro[nextX][nextY] += miro[node[0]][node[1]];
                    }
                }
            }
        }
    }

}
