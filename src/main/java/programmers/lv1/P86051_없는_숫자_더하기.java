package programmers.lv1;

import java.util.Arrays;

public class P86051_없는_숫자_더하기 {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }

    public static int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

}
