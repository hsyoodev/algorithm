package baekjoon.stack;

import java.util.*;
import java.io.*;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        answer[N - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[N - 1]);
        for (int i = N - 2; i >= 0; i--) {
            int number = numbers[i];
            while (!stack.isEmpty() && number >= stack.peek()) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(number);
        }
        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}
