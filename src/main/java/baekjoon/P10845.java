package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10845
public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<String> queue = new LinkedList<>();
        // 명령의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String order = stringTokenizer.nextToken();
            switch (order) {
                // 정수 X를 큐에 넣는 연산이다.
                case "push":
                    String X = stringTokenizer.nextToken();
                    queue.offer(X);
                    break;
                // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop":
                    bufferedWriter.write(queue.isEmpty() ? "-1" : queue.poll());
                    bufferedWriter.newLine();
                    break;
                // 큐에 들어있는 정수의 개수를 출력한다.
                case "size":
                    bufferedWriter.write(String.valueOf(queue.size()));
                    bufferedWriter.newLine();
                    break;
                // 큐가 비어있으면 1, 아니면 0을 출력한다.
                case "empty":
                    bufferedWriter.write(queue.isEmpty() ? "1" : "0");
                    bufferedWriter.newLine();
                    break;
                // 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "front":
                    bufferedWriter.write(queue.isEmpty() ? "-1" : queue.peekFirst());
                    bufferedWriter.newLine();
                    break;
                // 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "back":
                    bufferedWriter.write(queue.isEmpty() ? "-1" : queue.peekLast());
                    bufferedWriter.newLine();
                    break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
