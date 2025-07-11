package programmers.lv1;

public class P12931_자릿수_더하기 {

    public static void main(String[] args) {
        System.out.println(solution(123));
        System.out.println(solution(987));
    }

    public static int solution(int n) {
        int answer = 0;

        String[] numbers = String.valueOf(n).split("");

        for (String number : numbers) {
            answer += Integer.parseInt(number);
        }

        return answer;
    }

}
