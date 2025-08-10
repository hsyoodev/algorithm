package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class P12917_문자열_내림차순으로_배치하기 {

    public static void main(String[] args) {
        System.out.print(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String[] answer = s.split("");

        Arrays.sort(answer, Comparator.reverseOrder());

        return String.join("", answer);
    }

}
