package programmers.lv1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P42840_모의고사 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.print(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public static int[] solution(int[] answers) {
        int[][] supoja = {
                {1, 2, 3, 4, 5}
                , {2, 1, 2, 3, 2, 4, 2, 5}
                , {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = {0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < supoja.length; j++) {
                if (answers[i] == supoja[j][i % supoja[j].length]) {
                    scores[j]++;
                }
            }
        }

        int max = IntStream.of(scores).max().getAsInt();

        return IntStream.range(1, 4)
                .filter(i -> scores[i - 1] == max)
                .toArray();
    }

}
