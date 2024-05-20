package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/1874
public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        // 수열을 이루는 정수의 개수
        int n = Integer.parseInt(bufferedReader.readLine());
        // 다음 오름차순
        int nextAsc = 1;
        // 불가능 여부
        boolean isImpossible = false;
        for (int i = 0; i < n; i++) {
            // 정수
            int number = Integer.parseInt(bufferedReader.readLine());
            // 불가능한 경우
            if (nextAsc > number) {
                if (stack.isEmpty() || stack.peek() < number) {
                    isImpossible = true;
                    break;
                }
            }
            // 다음 오름차순이 정수보다 같거나 작은 경우
            while (nextAsc <= number) {
                stack.push(nextAsc++);
                stringBuilder.append("+\n");
            }
            // 스택이 비어있지않거나 스택의 현재 값이 정수보다 같거나 큰 경우
            while (!stack.isEmpty() && stack.peek() >= number) {
                stack.pop();
                stringBuilder.append("-\n");
            }
        }
        System.out.print(isImpossible ? "NO" : stringBuilder);
        bufferedReader.close();
    }
}
