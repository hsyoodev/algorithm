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
        int[] numbers = new int[N];
        int[] answer = new int[N];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            while (!arrayDeque.isEmpty() && numbers[arrayDeque.peekLast()] > numbers[i]) {
                arrayDeque.pollLast();
            }
            arrayDeque.offerLast(i);
            if (arrayDeque.peekFirst() <= i - L) {
                arrayDeque.pollFirst();
            }
            answer[i] = numbers[arrayDeque.peekFirst()];
        }
        for (int i = 0; i < N; i++) {
            bw.write(answer[i] + " ");
        }
        bw.flush();
    }
}
