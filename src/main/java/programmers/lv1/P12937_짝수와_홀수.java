package programmers.lv1;

public class P12937_짝수와_홀수 {

    public static void main(String[] args) {
        System.out.print(solution(12345));
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

}
