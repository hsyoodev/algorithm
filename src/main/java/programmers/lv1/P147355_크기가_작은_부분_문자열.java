package programmers.lv1;

public class P147355_크기가_작은_부분_문자열 {

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
        System.out.println(solution("500220839878", "7"));
        System.out.print(solution("10203", "15"));
    }

    public static int solution(String t, String p) {
        int answer = 0;

        for (int s = 0, e = p.length() - 1; e < t.length(); s++, e++) {
            if (Long.parseLong(t.substring(s, e + 1)) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }

}
