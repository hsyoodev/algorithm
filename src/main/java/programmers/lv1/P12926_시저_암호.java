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
            if (Character.isLowerCase((char) c)) {
                c = 97 + (c + n - 97) % 26;
            } else if (Character.isUpperCase((char) c)) {
                c = 65 + (c + n - 65) % 26;
            }

            return Character.toString(c);
        }).collect(Collectors.joining());

        return answer;
    }

}
