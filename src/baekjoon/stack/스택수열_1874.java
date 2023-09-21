package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder("");
        int[] inputs = new int[N];
        ArrayList<Integer> outputs = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            while (number <= inputs[i]) {
                stack.push(number++);
                answer.append("+\n");
            }
            while (!stack.isEmpty() && stack.peek() >= inputs[i]) {
                outputs.add(stack.pop());
                answer.append("-\n");
            }
        }
        for (int i = 0; i < N; i++) {
            if (inputs[i] != outputs.get(i)) {
                answer = new StringBuilder("NO");
                break;
            }
        }
        System.out.print(answer);
    }
}
