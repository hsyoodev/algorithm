package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {
    static int[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        maze = new int[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2];
        for (int i = 1; i < N + 1; i++) {
            char[] numbers = scanner.next().toCharArray();
            for (int j = 1; j < M + 1; j++) {
                maze[i][j] = numbers[j - 1] - '0';
            }
        }
        BFS(1, 1);
        System.out.print(maze[N][M]);
    }

    static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            for (int i = 0; i < 4; i++) {
                int targetX = xy[0] + directionX[i];
                int targetY = xy[1] + directionY[i];
                if (!visited[targetX][targetY] && maze[targetX][targetY] != 0) {
                    maze[targetX][targetY] += maze[xy[0]][xy[1]];
                    visited[targetX][targetY] = true;
                    queue.add(new int[]{targetX, targetY});
                }
            }
        }
    }
}
