package programmers.lv1;

import java.util.Arrays;

public class P12935_제일_작은_수_제거하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 2, 1})));
        System.out.print(Arrays.toString(solution(new int[]{10})));
    }

    public static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();

        return Arrays.stream(arr).filter(factor -> factor != min).toArray();
    }

}
