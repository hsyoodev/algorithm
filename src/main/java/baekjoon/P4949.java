package baekjoon;

import java.io.*;
import java.util.Stack;

// https://www.acmicpc.net/problem/4949
public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String str = bufferedReader.readLine();
            // 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
            if (str.equals(".")) {
                break;
            }
            // 모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
            // 모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
            // 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
            // 모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
            // 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case '(':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                }
            }
            bufferedWriter.write(stack.isEmpty() ? "yes" : "no");
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
