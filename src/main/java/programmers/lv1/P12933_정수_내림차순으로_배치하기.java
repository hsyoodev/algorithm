package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class P12933_정수_내림차순으로_배치하기 {

    public static void main(String[] args) {
        System.out.print(solution(118372));
    }

    public static long solution(long n) {
        return Long.parseLong(
                Arrays.stream(String.valueOf(n).split(""))
                        .map(Integer::parseInt)
                        .sorted(Comparator.reverseOrder())
                        .map(String::valueOf)
                        .collect(Collectors.joining())
        );
    }

}
