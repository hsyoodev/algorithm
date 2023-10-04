package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {
    static int[][] maze;
    static boolean[][] visited;
    static int[] xOffset = {-1, 0, 1, 0};
    static int[] yOffset = {0, 1, 0, -1};

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
        Queue<Coordinate> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Coordinate(x, y));
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            for (int i = 0; i < 4; i++) {
                int adjacencyX = coordinate.x + xOffset[i];
                int adjacencyY = coordinate.y + yOffset[i];
                if (!visited[adjacencyX][adjacencyY] && maze[adjacencyX][adjacencyY] != 0) {
                    maze[adjacencyX][adjacencyY] += maze[adjacencyX][adjacencyY];
                    visited[adjacencyX][adjacencyY] = true;
                    queue.add(new Coordinate(adjacencyX, adjacencyY));
                }
            }
        }
    }
}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
