package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 스택수열_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열을 이루는 정수의 갯수 N(1 ≤ N ≤ 100,000)
        int N = Integer.parseInt(br.readLine());
        // 스택 수열 stack
        Stack<Integer> stack = new Stack<>();
        // 필요한 연산 calculation
        StringBuilder calculation = new StringBuilder("");
        // 수열을 이루는 1이상 N이하의 중복되지 않는 정수 A
        int[] A = new int[N];
        // pop 연산 수행한 결과 저장 C
        List<Integer> C = new ArrayList<>();
        // N번의 반복
        for (int i = 0, num = 1; i < N; i++) {
            // 1 ~ N이하의 정수 하나씩 A에 저장
            A[i] = Integer.parseInt(br.readLine());
            // push 연산
            while (num <= A[i]) {
                stack.push(num++);
                calculation.append("+\n");
            }
            // pop 연산
            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                C.add(stack.pop());
                calculation.append("-\n");
            }
        }
        // A와 C의 모든 원소 같은지 여부 equal
        boolean equal = true;
        // A와 C의 모든 원소 같은지 확인
        for (int i = 0; i < N; i++) {
            if (A[i] != C.get(i)) {
                equal = false;
                break;
            }
        }
        System.out.print(equal ? calculation : "NO");
    }
}
