package programmers.LV2;

import java.util.Arrays;

public class P178870 {

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
//        int[] sequence = {1,1,1,2,3, 4, 5};
//        int k = 5;
//        int[] sequence = {2, 2, 2, 2, 2};
//        int k = 6;
        int startIndex = 0;
        int endIndex = 0;
        int sum = sequence[0];
        int[] answer = {0, sequence.length - 1};
        int length = answer[1] - answer[0];
        while (endIndex < sequence.length) {
            if (sum == k) {
                if (endIndex - startIndex < length) {
                    length = endIndex - startIndex;
                    answer[0] = startIndex;
                    answer[1] = endIndex;
                }
                sum -= sequence[startIndex++];
            } else if (sum < k) {
                if (++endIndex < sequence.length) {
                    sum += sequence[endIndex];
                }
            } else if (sum > k) {
                sum -= sequence[startIndex++];
            }
        }
        System.out.print(Arrays.toString(answer));
    }
}
