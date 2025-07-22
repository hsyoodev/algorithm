package programmers.lv1;

public class P12934_정수_제곱근_판별 {

    public static void main(String[] args) {
        System.out.print(solution(121));
    }

    public static long solution(long n) {
        long answer = 1;

        for (answer = 1; answer * answer <= n; answer++) {
            if (answer * answer == n) {
                return (answer + 1) * (answer + 1);
            }
        }

        return -1;
    }

}
