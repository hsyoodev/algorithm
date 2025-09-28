package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P176963_추억_점수 {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        System.out.print(Arrays.toString(solution(name, yearning, photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            answer[i] = Arrays.stream(photo[i]).mapToInt((n) -> map.getOrDefault(n, 0)).sum();
        }

        return answer;
    }

}
