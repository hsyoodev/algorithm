package baekjoon.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색_2178 {
    static int N;
    static int M;
    static int[][] maze;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        maze = new int[N + 2][M + 2];
        for (int i = 1; i < N + 1; i++) {
            char[] numbers = scanner.next().toCharArray();
            for (int j = 1; j < M + 1; j++) {
                maze[i][j] = numbers[j - 1] - '0';
            }
        }
        BFS(1, 1);

    }

    static void BFS(int rowIndex, int columnIndex) {
        int current = maze[rowIndex][columnIndex];
        int up = maze[rowIndex - 1][columnIndex];
        int down = maze[rowIndex + 1][columnIndex];
        int left = maze[rowIndex][columnIndex - 1];
        int right = maze[rowIndex][columnIndex + 1];

        if (up == 1 ) {
            maze[rowIndex - 1][columnIndex] += current;
        }
        if (down == 1) {
            maze[rowIndex + 1][columnIndex] += current;
        }
        if (left == 1) {
            maze[rowIndex][columnIndex - 1] += current;
        }
        if (right == 1) {
            maze[rowIndex][columnIndex + 1] += current;
        }
    }
}
