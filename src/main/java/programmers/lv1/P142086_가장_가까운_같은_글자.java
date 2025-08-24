package programmers.lv1;

import java.util.Arrays;

public class P142086_가장_가까운_같은_글자 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
        System.out.print(Arrays.toString(solution("foobar")));
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] characters = s.split("");

        for (int i = 0; i < characters.length; i++) {
            int findIndex = s.substring(0, i).lastIndexOf(characters[i]);

            if (findIndex != -1) {
                answer[i] = i - findIndex;
            } else {
                answer[i] = findIndex;
            }
        }

        return answer;
    }

}
