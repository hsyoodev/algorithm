package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// https://www.acmicpc.net/problem/17413
public class P17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        // 문자열
        String S = bufferedReader.readLine();
        Deque<Character> deque = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        boolean isLessThan = false;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            switch (c) {
                case ' ':
                    if (isLessThan) {
                        deque.offer(c);
                    } else {
                        while (!deque.isEmpty()) {
                            stringBuilder.append(deque.pollLast());
                        }
                        stringBuilder.append(c);
                    }
                    break;
                case '<':
                    isLessThan = true;
                    deque.offer(c);
                    break;
                case '>':
                    while (!deque.isEmpty() && deque.peekLast() != '<') {
                        stack.push(deque.pollLast());
                    }
                    stack.push(deque.pollLast());
                    while (!deque.isEmpty()) {
                        stringBuilder.append(deque.pollLast());
                    }
                    while (!stack.isEmpty()) {
                        stringBuilder.append(stack.pop());
                    }
                    stringBuilder.append(c);
                    isLessThan = false;
                    break;
                default:
                    deque.offer(c);
                    break;
            }
        }
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pollLast());
        }
        System.out.print(stringBuilder);
        bufferedReader.close();
    }
}
