package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10866
public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<String> deque = new ArrayDeque<>();
        // 명령의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String order = stringTokenizer.nextToken();
            String X;
            switch (order) {
                // 정수 X를 덱의 앞에 넣는다.
                case "push_front":
                    X = stringTokenizer.nextToken();
                    deque.offerFirst(X);
                    break;
                // 정수 X를 덱의 뒤에 넣는다.
                case "push_back":
                    X = stringTokenizer.nextToken();
                    deque.offerLast(X);
                    break;
                // 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop_front":
                    bufferedWriter.write(deque.isEmpty() ? "-1" : deque.pollFirst());
                    bufferedWriter.newLine();
                    break;
                // 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop_back":
                    bufferedWriter.write(deque.isEmpty() ? "-1" : deque.pollLast());
                    bufferedWriter.newLine();
                    break;
                // 덱에 들어있는 정수의 개수를 출력한다.
                case "size":
                    bufferedWriter.write(String.valueOf(deque.size()));
                    bufferedWriter.newLine();
                    break;
                // 덱이 비어있으면 1을, 아니면 0을 출력한다.
                case "empty":
                    bufferedWriter.write(deque.isEmpty() ? "1" : "0");
                    bufferedWriter.newLine();
                    break;
                // 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "front":
                    bufferedWriter.write(deque.isEmpty() ? "-1" : deque.peekFirst());
                    bufferedWriter.newLine();
                    break;
                // 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "back":
                    bufferedWriter.write(deque.isEmpty() ? "-1" : deque.peekLast());
                    bufferedWriter.newLine();
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
