package programmers.lv1;

public class P12912_두_정수_사이의_합 {

    public static void main(String[] args) {
        System.out.print(solution(3, 3));
    }

    public static long solution(int a, int b) {
        return (long) (b - a + 1) * (a + b) / 2;
    }

}
