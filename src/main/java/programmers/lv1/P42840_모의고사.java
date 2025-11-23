package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P42840_모의고사 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.print(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == arr1[i % arr1.length]) {
                sum1++;
            }

            if (answers[i] == arr2[i % arr2.length]) {
                sum2++;
            }

            if (answers[i] == arr3[i % arr3.length]) {
                sum3++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int max = Math.max(sum1, Math.max(sum2, sum3));

        if (sum1 == max) {
            list.add(1);
        }

        if (sum2 == max) {
            list.add(2);
        }

        if (sum3 == max) {
            list.add(3);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
