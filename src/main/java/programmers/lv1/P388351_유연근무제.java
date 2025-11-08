package programmers.lv1;

public class P388351_유연근무제 {

    public static void main(String[] args) {
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;

        System.out.print(solution(schedules, timelogs, startday));
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;

        for (int i = 0; i < timelogs.length; i++) {
            int limit = schedules[i] % 100 + 10 >= 60 ? schedules[i] + 50 : schedules[i] + 10;

            for (int j = 0, tempStartday = startday; j < timelogs[i].length; j++, tempStartday++) {
                if (tempStartday % 7 == 6 || tempStartday % 7 == 0) {
                    continue;
                }

                if (limit < timelogs[i][j]) {
                    answer--;

                    break;
                }
            }
        }

        return answer;
    }

}
