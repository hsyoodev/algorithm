package baekjoon.data_structures;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/1918
public class P1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 중위 표기식
        String medianNotation = bufferedReader.readLine();
        // 후외 표기식
        Stack<Character> stack = new Stack<>();
        // 중위 표기식을 후위 표기식으로 바꾸는 방법
        for (int i = 0; i < medianNotation.length(); i++) {
            char c = medianNotation.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                        bufferedWriter.write(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        bufferedWriter.write(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    bufferedWriter.write(c);
            }
        }
        while (!stack.isEmpty()) {
            bufferedWriter.write(stack.pop());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    public static int getPriority(char c) {
        int priority = -1;
        switch (c) {
            case '(':
            case ')':
                priority = 0;
                break;
            case '+':
            case '-':
                priority = 1;
                break;
            case '*':
            case '/':
                priority = 2;
                break;
        }
        return priority;
    }
}
