package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17298
public class P17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 수열 A의 크기
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        // 각 원소 Ai에 대해서 오큰수 NGE(i)
        int[] NGES = new int[N];
        NGES[N - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(A[N - 1]);
        // 각 원소 Ai에 대해서 오큰수 NGE(i) 구하기
        for (int i = N - 2; i >= 0; i--) {
            int a = A[i];
            int NGE = -1;
            while (!stack.isEmpty()) {
                if (a < stack.peek()) {
                    NGE = stack.peek();
                    stack.push(a);
                    break;
                } else {
                    stack.pop();
                }
            }
            stack.push(a);
            NGES[i] = NGE;
        }
        for (int i = 0; i < N; i++) {
            bufferedWriter.write(NGES[i] + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
