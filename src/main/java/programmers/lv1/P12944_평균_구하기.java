package programmers.lv1;

import java.util.Arrays;

public class P12944_평균_구하기 {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{1, 2, 3, 4}));
    }

    public static double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

}
