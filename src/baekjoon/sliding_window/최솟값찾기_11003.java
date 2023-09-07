package baekjoon.sliding_window;

import java.io.*;
import java.util.*;

public class 최솟값찾기_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] value = new int[N];
        int[] result = new int[N];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && value[deque.peekLast()] > value[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() <= i - L) {
                deque.pollFirst();
            }
            result[i] = value[deque.peekFirst()];
        }
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
    }
}
