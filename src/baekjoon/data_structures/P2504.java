package baekjoon.data_structures;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/2504
public class P2504 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 괄호열을 나타내는 문자열
        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int calculation = 1;
        boolean isError = false;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (now == '(') {
                stack.push(now);
                calculation *= 2;
            } else if (now == '[') {
                stack.push(now);
                calculation *= 3;
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    isError = true;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    answer += calculation;
                }
                stack.pop();
                calculation /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    isError = true;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    answer += calculation;
                }
                stack.pop();
                calculation /= 3;
            }
        }
        if (answer == 0 || isError || !stack.isEmpty()) {
            System.out.print(0);
        } else {
            System.out.print(answer);
        }
    }
}
