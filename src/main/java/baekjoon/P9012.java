package baekjoon;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 데이터의 수
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            // 괄호 문자열
            String PS = bufferedReader.readLine();
            // 올바른 괄호 문자열(VPS) 검증
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < PS.length(); j++) {
                char parenthesis = PS.charAt(j);
                // '('인경우 stack에 값을 push
                if (parenthesis == '(') {
                    stack.push(parenthesis);
                }
                // ')'인경우
                else if (parenthesis == ')') {
                    // stack이 비어있지않거나 현재 값이 '('인경우 값을 pop
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    // 그 이외는 stack에 값을 push
                    else {
                        stack.push(parenthesis);
                    }
                }
            }
            bufferedWriter.write(stack.isEmpty() ? "YES" : "NO");
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

