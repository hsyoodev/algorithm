package baekjoon.gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715_카드_정렬하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            priorityQueue.add(scanner.nextInt());
        }

        int answer = 0;
        while (priorityQueue.size() > 1) {
            int A = priorityQueue.poll();
            int B = priorityQueue.poll();
            int bundle = A + B;

            priorityQueue.add(bundle);
            answer += (bundle);
        }

        System.out.println(answer);
    }

}
