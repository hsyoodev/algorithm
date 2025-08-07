package programmers.lv1;

import java.util.stream.IntStream;

public class P70128_내적 {

    public static void main(String[] args) {
        System.out.print(solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
    }

    public static int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }

}
