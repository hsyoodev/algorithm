package programmers.lv1;

import java.time.LocalDate;

public class P12901_2016년 {

    public static void main(String[] args) {
        System.out.print(solution(5, 24));
    }

    public static String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }

}
