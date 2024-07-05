package baekjoon;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/9935
public class P9935 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 문자열
        String letters = scanner.nextLine();
        // 폭발 문자열
        String bombLetters = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < letters.length(); i++) {
            stack.push(letters.charAt(i));
            if (stack.size() >= bombLetters.length()) {
                // 폭발 문자열인지 검증
                boolean isEqual = true;
                for (int j = 0; j < bombLetters.length(); j++) {
                    if (stack.get(stack.size() - bombLetters.length() + j) != bombLetters.charAt(j)) {
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    for (int j = 0; j < bombLetters.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        System.out.print(stack.isEmpty() ?
                "FRULA" : stack.stream().map(String::valueOf).collect(Collectors.joining())
        );
    }
}
