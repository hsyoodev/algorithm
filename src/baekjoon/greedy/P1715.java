package baekjoon.greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(sc.nextInt());
        }
        int sum = 0;
        while (queue.size() >= 2) {
            int A = queue.poll();
            int B = queue.poll();
            sum += A + B;
            queue.offer(A + B);
        }
        System.out.print(sum);
    }
}
