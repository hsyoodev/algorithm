package programmers.lv1;

import java.util.Arrays;

public class P12954_x만큼_간격이_있는_n개의_숫자 {

    public static void main(String[] args) {
        System.out.print(Arrays.toString(solution(2, 5)));
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 1; i <= n; i++) {
            answer[i - 1] = (long) x * i;
        }

        return answer;
    }

}
