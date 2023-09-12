package baekjoon.sorting;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class 수정렬하기3_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        Queue<Integer>[] queues = new Queue[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            queues[num % 10].offer(num);
        }
        boolean isEmpty = false;
        int digit = 10;
        int size = 0;
        int count = 0;
        int num = 0;
        int temp = 0;
        while (!isEmpty) {
            for (int i = 0; i < 10; i++) {
                size = queues[i].size();
                count = 0;
                while (size != count) {
                    num = queues[i].poll();
                    count++;
                    if ((num / digit) == 0) {
                        A.add(num);
                    } else {
                        temp = num;
                        while (temp >= (digit * 10)) {
                            temp -= (digit * 10);
                        }
                        queues[temp / digit].offer(num);
                    }
                }
            }
            isEmpty = true;
            for (int i = 0; i < 10; i++) {
                if (!queues[i].isEmpty()) {
                    isEmpty = false;
                    break;
                }
            }
            digit*=10;
        }
        for (int i = 0; i < N; i++) {
            bw.write(A.get(i) + "\n");
        }
        bw.flush();
    }
}
