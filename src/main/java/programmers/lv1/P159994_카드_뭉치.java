package programmers.lv1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class P159994_카드_뭉치 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
        System.out.print(solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
        Queue<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));

        for (String s : goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(s)) {
                queue1.poll();
            } else if (!queue2.isEmpty() && queue2.peek().equals(s)) {
                queue2.poll();
            } else {
                return "No";
            }
        }

        return "Yes";
    }

}
