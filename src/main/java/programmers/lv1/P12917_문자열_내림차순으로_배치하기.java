package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class P12917_문자열_내림차순으로_배치하기 {

    public static void main(String[] args) {
        System.out.print(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        return Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }

}
