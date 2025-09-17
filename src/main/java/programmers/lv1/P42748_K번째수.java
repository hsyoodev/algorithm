package programmers.lv1;

import java.util.Arrays;

public class P42748_K번째수 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.print(Arrays.toString(solution(array, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];

            answer[l] = Arrays.stream(array)
                    .skip(i - 1).limit(j - i + 1)
                    .sorted()
                    .skip(k - 1).limit(1)
                    .findFirst()
                    .getAsInt();
        }

        return answer;
    }

}
