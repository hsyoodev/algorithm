package baekjoon;

import java.util.*;

// https://www.acmicpc.net/problem/3190
public class P3190 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 보드의 크기
        int N = scanner.nextInt();
        int[][] board = new int[N][N];
        // 사과의 개수
        int K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            board[row - 1][col - 1] = 1;
        }
        // 뱀의 방향 변환 횟수
        int L = scanner.nextInt();
        Deque<Node> nodes = new ArrayDeque<>();
        // 뱀의 방향 변환 정보
        Queue<Direction> directions = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            int X = scanner.nextInt();
            String C = scanner.next();
            directions.offer(new Direction(X, C));
        }
        int[][] offset = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        int row = 0;
        int col = 0;
        // 뱀의 몸길이
        int length = 1;
        // 게임이 몇 초에 끝나는지
        int answer = 0;
        while (true) {
            // 벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
            if ((row >= N || col >= N || row < 0 || col < 0) || board[row][col] == 2) {
                break;
            }
            // 사과를 먹으면 뱀 길이가 늘어난다.
            if (board[row][col] == 1) {
                length++;
            }
            nodes.offerFirst(new Node(row, col));
            board[row][col] = 2;
            // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
            if (length < nodes.size()) {
                Node node = nodes.pollLast();
                board[node.row][node.col] = 0;
            }
            if (!directions.isEmpty()) {
                // 게임 시작 시간으로부터 X초가 끝난 뒤에
                if (answer == directions.peek().X) {
                    Direction direction = directions.poll();
                    switch (direction.C) {
                        // 왼쪽(C가 'L') 또는
                        case "L":
                            index = (index == 0) ? 3 : index - 1;
                            break;
                        // 오른쪽(C가 'D')로 90도 방향을 회전
                        case "D":
                            index = (index == 3) ? 0 : index + 1;
                            break;
                    }
                }
            }
            row += offset[index][0];
            col += offset[index][1];
            answer++;
        }
        System.out.print(answer);
    }
}

class Node {
    int row;
    int col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Direction {
    int X;
    String C;

    Direction(int X, String C) {
        this.X = X;
        this.C = C;
    }
}
