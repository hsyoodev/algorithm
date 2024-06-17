package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3190
public class P3190 {
    static StringTokenizer stringTokenizer;
    // 보드의 크기
    static int N;
    // 정사각 보드
    static int[][] board;
    // 뱀의 위치
    static Deque<int[]> nodes = new ArrayDeque<>();
    // 뱀의 방향 전환 목록
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // 현재 뱀의 방향 목록 인덱스
    static int index = 0;
    // 만약 벽이나 자기자신의 몸과 부딪힌 경우인지
    static boolean isError = false;
    // 방향 전환 시간
    static int X;
    // 게임이 몇 초에 끝나는지
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 보드의 크기
        N = Integer.parseInt(bufferedReader.readLine());
        board = new int[N][N];
        // 사과의 개수
        int K = Integer.parseInt(bufferedReader.readLine());
        // 사과의 위치
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int row = Integer.parseInt(stringTokenizer.nextToken());
            int col = Integer.parseInt(stringTokenizer.nextToken());
            board[row - 1][col - 1] = 2;
        }
        // 게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다.
        nodes.offer(new int[]{0, 0});
        board[0][0] = 1;
        // 뱀의 방향 변환 횟수
        int L = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < L; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            X = Integer.parseInt(stringTokenizer.nextToken());

            startGame(true);

            if (isError) {
                break;
            }
        }

        if (!isError) {
            startGame(false);
        }

        System.out.print(answer);
        bufferedReader.close();
    }

    public static void startGame(boolean isL) {
        while (true) {
            if (isL) {
                // X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전
                if (answer == X) {
                    String C = stringTokenizer.nextToken();
                    if (C.equals("D")) {
                        index = (index == 3) ? 0 : (index + 1);
                    } else {
                        index = (index == 0) ? 3 : (index - 1);
                    }
                    break;
                }
            }

            int[] direction = directions[index];
            int[] node = nodes.peek();
            int row = node[0] + direction[0];
            int col = node[1] + direction[1];

            // 벽이나
            if (row < 0 || row > N - 1 || col < 0 || col > N - 1) {
                isError = true;
                answer++;
                break;
            }
            // 자기자신의 몸
            if (board[row][col] == 1) {
                isError = true;
                answer++;
                break;
            }

            // 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
            // 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
            if (board[row][col] == 0) {
                nodes.offerFirst(new int[]{row, col});
                board[row][col] = 1;
                node = nodes.pollLast();
                board[node[0]][node[1]] = 0;
            }
            // 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
            else if (board[row][col] == 2) {
                nodes.offerFirst(new int[]{row, col});
                board[row][col] = 1;
            }

            answer++;
        }
    }
}