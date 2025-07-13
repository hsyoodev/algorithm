package programmers.lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class P12932_자연수_뒤집어_배열로_만들기 {

    public static void main(String[] args) {
        System.out.print(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        List<IntStream> answer = List.of(String.valueOf(n).chars().map(Character::getNumericValue));

        Collections.reverse(Arrays.asList(answer));

        return null;
    }

}
