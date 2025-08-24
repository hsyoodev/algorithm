package programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P142086_가장_가까운_같은_글자 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
        System.out.print(Arrays.toString(solution("foobar")));
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            answer[i] = i - map.getOrDefault(c, i + 1);
            map.put(c, i);
        }

        return answer;
    }

}
