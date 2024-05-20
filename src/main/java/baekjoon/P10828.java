package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10828
public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 명령의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String order = stringTokenizer.nextToken();
            switch (order) {
                // 정수 X를 스택에 넣는 연산이다.
                case "push":
                    String X = stringTokenizer.nextToken();
                    stack.push(X);
                    break;
                // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop":
                    bufferedWriter.write(stack.isEmpty() ? "-1" : stack.pop());
                    bufferedWriter.newLine();
                    break;
                // 스택에 들어있는 정수의 개수를 출력한다.
                case "size":
                    bufferedWriter.write(String.valueOf(stack.size()));
                    bufferedWriter.newLine();
                    break;
                // 스택이 비어있으면 1, 아니면 0을 출력한다.
                case "empty":
                    bufferedWriter.write(stack.isEmpty() ? "1" : "0");
                    bufferedWriter.newLine();
                    break;
                // 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "top":
                    bufferedWriter.write(stack.isEmpty() ? "-1" : stack.peek());
                    bufferedWriter.newLine();
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
