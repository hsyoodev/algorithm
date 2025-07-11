package programmers.lv1;

public class P12928_약수의_합 {

    public static void main(String[] args) {
        System.out.print(solution(12));
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer + n;
    }

}
