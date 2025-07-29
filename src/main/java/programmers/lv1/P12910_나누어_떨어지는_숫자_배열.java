package programmers.lv1;

import java.util.Arrays;

public class P12910_나누어_떨어지는_숫자_배열 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5)));
        System.out.print(Arrays.toString(solution(new int[]{3, 2, 6}, 10)));
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).sorted().toArray();

        if (answer.length == 0) {
            return new int[]{-1};
        }

        return answer;
    }

}
