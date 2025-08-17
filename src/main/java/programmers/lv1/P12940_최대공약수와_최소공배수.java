package programmers.lv1;

import java.util.Arrays;

public class P12940_최대공약수와_최소공배수 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
        System.out.print(Arrays.toString(solution(2, 5)));
    }

    public static int[] solution(int n, int m) {
        int gcd = GCD(n, m);
        int lcm = (n * m) / gcd;

        return new int[]{gcd, lcm};
    }

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        return GCD(b, a % b);
    }

}
