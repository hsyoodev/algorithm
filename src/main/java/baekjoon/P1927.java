package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1927
public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 연산의 개수
        int N = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            // 입력에서 0이 주어진 횟수만큼 답을 출력
            if (number == 0) {
                // 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력
                bufferedWriter.write(numbers.isEmpty() ? "0" : String.valueOf(numbers.poll()));
                bufferedWriter.newLine();
            } else {
                numbers.add(number);
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
