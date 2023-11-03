package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1931 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Meeting> meetingList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            meetingList.add(new Meeting(startTime, endTime));
        }
        Collections.sort(meetingList);
        int endTime = meetingList.get(0).endTime;
        int answer = 1;
        for (int i = 1; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if (meeting.endTime < endTime) {
                endTime = meeting.endTime;
            } else if (meeting.startTime >= endTime) {
                endTime = meeting.endTime;
                answer++;
            }
        }
        System.out.print(answer);
    }
}

class Meeting implements Comparable<Meeting> {

    public int startTime;
    public int endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if (startTime == o.startTime) {
            return endTime - o.endTime;
        }
        return startTime - o.startTime;
    }
}
