package baekjoon.sliding_window;

import java.io.*;
import java.util.*;

public class 최솟값찾기_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N개의 수(1 ≤ L ≤ N ≤ 5,000,000)
        int N = Integer.parseInt(st.nextToken());
        // D를 구하는데 필요한 연산 L(1 ≤ L ≤ N ≤ 5,000,000)
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // N개의 수 A
        int[] A = new int[N];
        // L범위의 D값 priorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // N번 반복
        for (int i = 0; i < N; i++) {
            if (i >= L) {
                // 이전 L범위 숫자 remove
                priorityQueue.remove(A[i - L]);
            }
            // A 초기화
            A[i] = Integer.parseInt(st.nextToken());
            // 다음 L범위 숫자 offer
            priorityQueue.offer(A[i]);
            bw.write(priorityQueue.peek() + " ");
        }
        bw.flush();
        // TreeMap 방식
//        long s = System.nanoTime();
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        for (int i = 0; i < N; i++) {
//            if (i >= L) {
//                if (map.get(A[i - L]) > 1) {
//                    map.put(A[i - L], map.get(A[i - L]) - 1);
//                } else {
//                    map.remove(A[i - L]);
//                }
//            }
//            A[i] = Integer.parseInt(st.nextToken());
//            map.put(A[i], map.getOrDefault(A[i] , 0) + 1);
//            bw.write(map.firstKey() + " ");
//            bw.flush();
//        }
//        long e = System.nanoTime();
//        System.out.println(e - s);
//        bw.close();
    }
}
