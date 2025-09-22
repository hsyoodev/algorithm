package programmers.lv1;

public class P132267_콜라_문제 {

    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20));
        System.out.println(solution(3, 1, 20));
        System.out.print(solution(3, 2, 4));
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            answer += (n / a) * b;
            n = (n / a) * b + (n % a);
        }

        return answer;
    }

}
