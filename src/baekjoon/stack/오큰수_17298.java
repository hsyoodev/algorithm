package baekjoon.stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수열 A의 크기 N
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수열 A
        int[] A = new int[N];
        // A 초기화
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 총 N개의 오큰수 NGES
        int[] NGES = new int[N];
        // 끝 원소의 오큰수는 항상 -1이기때문에 미리 초기화
        NGES[N - 1] = -1;
        // 오큰수 연산에 쓰일 자료구조 stack
        Stack<Integer> stack = new Stack<>();
        // 끝 원소의 오큰수는 항상 -1이기때문에 미리 초기화
        stack.push(A[N - 1]);
        // A[N - 2]부터 ~ A[0]까지
        for (int i = N - 2; i >= 0; i--) {
            // 현재 원소
            int curE = A[i];
            // stack이 비어있지않고 현재 stack이 가리키는 원소 < 현재 원소인경우에 pop 연산
            while (!stack.isEmpty() && curE > stack.peek()) {
                stack.pop();
            }
            NGES[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(curE);
        }
        // 총 N개의 오큰수 NGES 출력
        for (int i = 0; i < N; i++) {
            bw.write(NGES[i] + " ");
        }
        bw.flush();
    }
}
