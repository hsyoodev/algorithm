package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/10828
public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 명령의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        // N개의 명령
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] order = bufferedReader.readLine().split(" ");
            switch (order[0]) {
                // push X: 정수 X를 스택에 넣는 연산이다.
                case "push":
                    stack.push(order[1]);
                    break;
                // pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                // size: 스택에 들어있는 정수의 개수를 출력한다.
                case "size":
                    System.out.println(stack.size());
                    break;
                // empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                // top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }
    }
}
