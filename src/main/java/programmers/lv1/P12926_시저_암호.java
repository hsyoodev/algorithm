package programmers.lv1;

import java.util.stream.Collectors;

public class P12926_시저_암호 {

    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.print(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        String answer = s.chars().mapToObj(c -> {
            if (c == 32) {
                return Character.toString(c);
            }

            for (int i = 1; i <= n; i++) {
                c += 1;

                if (c == 91) {
                    c = 65;
                } else if (c == 123) {
                    c = 97;
                }
            }

            return Character.toString(c);
        }).collect(Collectors.joining());

        return answer;
    }

}
