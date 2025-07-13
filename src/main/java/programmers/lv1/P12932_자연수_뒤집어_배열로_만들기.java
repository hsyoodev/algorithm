package programmers.lv1;

import java.util.Arrays;

public class P12932_자연수_뒤집어_배열로_만들기 {

    public static void main(String[] args) {
        System.out.print(Arrays.toString(solution(12345)));
    }

    public static int[] solution(long n) {
        return new StringBuilder()
                .append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

}
