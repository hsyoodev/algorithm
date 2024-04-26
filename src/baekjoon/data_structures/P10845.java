package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/10845
public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> queue = new LinkedList<>();
        // 명령의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        // N개의 명령
        for (int i = 0; i < N; i++) {
            String[] order = bufferedReader.readLine().split(" ");
            switch (order[0]) {
                // push X: 정수 X를 큐에 넣는 연산이다.
                case "push":
                    queue.offer(order[1]);
                    break;
                // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;
                // size: 큐에 들어있는 정수의 개수를 출력한다.
                case "size":
                    System.out.println(queue.size());
                    break;
                // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.getFirst());
                    break;
                // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.getLast());
                    break;
            }
        }
    }
}
