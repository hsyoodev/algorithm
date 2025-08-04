package programmers.lv1;

public class P12903_가운데_글자_가져오기 {

    public static void main(String[] args) {
        System.out.print(solution("abcde"));
    }

    public static String solution(String s) {
        int startIndex = s.length() % 2 == 0 ? (s.length() / 2) - 1 : (s.length() / 2);
        int endIndex = s.length() % 2 == 0 ? startIndex + 2 : startIndex + 1;

        return s.substring(startIndex, endIndex);
    }

}
