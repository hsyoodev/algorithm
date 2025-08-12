package programmers.lv1;

public class P12918_문자열_다루기_기본 {

    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.print(solution("1234"));
    }

    public static boolean solution(String s) {
        return s.matches("\\d{4}|\\d{6}");
    }

}
