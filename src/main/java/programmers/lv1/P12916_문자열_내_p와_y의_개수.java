package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class P12916_문자열_내_p와_y의_개수 {

    public static void main(String[] args) {
        System.out.print(solution("Pyy"));
    }

    public static boolean solution(String s) {
        Map<Character, Integer> alphabetCounts = new HashMap<>();

        for (char alphabet : s.toLowerCase().toCharArray()) {
            alphabetCounts.put(alphabet, alphabetCounts.getOrDefault(alphabet, 0) + 1);
        }

        return alphabetCounts.get('p') == alphabetCounts.get('y');
    }
}
