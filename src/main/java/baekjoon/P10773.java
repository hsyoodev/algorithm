package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/10773
public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        // K개의 정수
        int K = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            // 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고,
            if (number == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            // 아닐 경우 해당 수를 쓴다.
            else {
                stack.push(number);
            }
        }
        // 재민이가 최종적으로 적어 낸 수의 합
        int sum = stack.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.print(sum);
        bufferedReader.close();
    }
}
