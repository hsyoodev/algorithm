package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/4949
public class P4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Stack<String> stack = new Stack<>();
            String str = bufferedReader.readLine();
            // 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
            if (str.equals(".")) {
                break;
            }
            // 괄호들의 균형이 잘 맞춰져 있는지 판단
            String[] strs = str.split("");
            for (int i = 0; i < strs.length; i++) {
                switch (strs[i]) {
                    case "(":
                    case "[":
                        stack.push(strs[i]);
                        break;
                    case ")":
                        if (!stack.isEmpty() && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stack.push(strs[i]);
                        }
                        break;
                    case "]":
                        if (!stack.isEmpty() && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            stack.push(strs[i]);
                        }
                        break;
                }
            }
            // 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"
            System.out.println(stack.isEmpty() ? "yes" : "no");
        }
    }
}
