package programmers.lv1;

public class P12916_문자열_내_p와_y의_개수 {

    public static void main(String[] args) {
        System.out.print(solution("pPoooyY"));
    }

    public static boolean solution(String s) {
        s = s.toLowerCase();

        return s.chars().filter(c -> c == 'p').count() == s.chars().filter(c -> c == 'y').count();
    }
    
}
