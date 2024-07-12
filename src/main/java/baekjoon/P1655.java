package baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/1655
public class P1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Comparator.reverseOrder());
        // 정수의 개수
        int N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (asc.size() == desc.size()) {
                desc.offer(number);
            } else {
                asc.offer(number);
            }
            if (!asc.isEmpty() && !desc.isEmpty()) {
                if (desc.peek() > asc.peek()) {
                    asc.offer(desc.poll());
                    desc.offer(asc.poll());
                }
            }
            bufferedWriter.write(desc.peek() + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
