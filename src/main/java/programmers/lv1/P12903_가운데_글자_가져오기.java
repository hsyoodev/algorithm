package programmers.lv1;

public class P12903_가운데_글자_가져오기 {

    public static void main(String[] args) {
        System.out.print(solution("abcde"));
    }

    public static String solution(String s) {
        return s.substring((s.length() - 1) / 2, (s.length() / 2) + 1);
    }

}
