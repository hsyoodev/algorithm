package programmers.lv1;

public class P12934_정수_제곱근_판별 {

    public static void main(String[] args) {
        System.out.print(solution(3));
    }

    public static long solution(long n) {
        if ((int) Math.pow(Math.sqrt(n), 2) == n) {
            return (long) Math.pow(Math.sqrt(n) + 1, 2);
        }

        return -1;
    }

}
