package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/9935
public class P9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 첫째 줄에 문자열이 주어진다.
        String str = bufferedReader.readLine();
        // 둘째 줄에 폭발 문자열이 주어진다.
        String bombStr = bufferedReader.readLine();
        // 폭발은 다음과 같은 과정으로 진행된다.
        // 1. 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
        // 2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
        // 3. 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= bombStr.length()) {
                boolean isEqual = true;
                for (int j = 0; j < bombStr.length(); j++) {
                    if (stack.get(stack.size() - bombStr.length() + j) != bombStr.charAt(j)) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    for (int j = 0; j < bombStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        // 모든 폭발이 끝난 후 남은 문자열을 출력
        System.out.print(stack.isEmpty() ? "FRULA" : stack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }
}
