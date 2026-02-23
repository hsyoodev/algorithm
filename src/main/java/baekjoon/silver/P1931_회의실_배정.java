package baekjoon.silver;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1931_회의실_배정 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        PriorityQueue<Reservation> priorityQueue = new PriorityQueue<>(
                (a, b) -> {
                    if (a.start == b.start) {
                        return a.end - b.end;
                    }

                    return a.start - b.start;
                }
        );

        for (int i = 0; i < N; i++) {
            priorityQueue.add(new Reservation(scanner.nextInt(), scanner.nextInt()));
        }

        Reservation reservation = priorityQueue.poll();
        int currentStart = reservation.start;
        int currentEnd = reservation.end;
        int answer = 1;
        while (!priorityQueue.isEmpty()) {
            reservation = priorityQueue.poll();

            if (reservation.start < currentEnd) {
                if (reservation.end <= currentEnd) {
                    currentEnd = reservation.end;
                }
            } else {
                currentEnd = reservation.end;
                answer++;
            }
        }
        
        System.out.print(answer);
    }

    static class Reservation {

        int start;
        int end;

        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

}
