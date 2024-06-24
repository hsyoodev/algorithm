package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2493
public class P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 탑의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Stack<Top> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            Top top = new Top(i + 1, Integer.parseInt(stringTokenizer.nextToken()));
            // 현재 탑의 높이보다 낮은 탑 제거
            while (!stack.isEmpty() && stack.peek().height <= top.height) {
                stack.pop();
            }
            // 레이저 신호를 수신하는 탑이 존재하지 않으면 0을 출력한다.
            if (stack.isEmpty()) {
                bufferedWriter.write("0 ");
            }
            // 레이저 신호를 수신하는 탑이 존재하면 수신한 탑의 위치를 출력한다.
            else {
                bufferedWriter.write(stack.peek().index + " ");
            }
            stack.push(top);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class Top {
    int index;
    int height;

    public Top(int index, int height) {
        this.index = index;
        this.height = height;
    }
}
