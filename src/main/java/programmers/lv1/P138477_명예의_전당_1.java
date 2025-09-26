package programmers.lv1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P138477_명예의_전당_1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
        System.out.print(Arrays.toString(solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            priorityQueue.offer(score[i]);

            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            answer[i] = priorityQueue.peek();
        }

        return answer;
    }
    
}
