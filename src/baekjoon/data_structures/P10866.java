package baekjoon.data_structures;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// https://www.acmicpc.net/problem/10866
public class P10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 명령의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        // N개의 명령
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            String[] order = bufferedReader.readLine().split(" ");
            switch (order[0]) {
                // push_front X: 정수 X를 덱의 앞에 넣는다.
                case "push_front":
                    deque.offerFirst(order[1]);
                    break;
                // push_back X: 정수 X를 덱의 뒤에 넣는다.
                case "push_back":
                    deque.offerLast(order[1]);
                    break;
                // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop_front":
                    System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
                    break;
                // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop_back":
                    System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
                    break;
                // size: 덱에 들어있는 정수의 개수를 출력한다.
                case "size":
                    System.out.println(deque.size());
                    break;
                // empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                // front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "front":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                // back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "back":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
            }
        }
    }
}
