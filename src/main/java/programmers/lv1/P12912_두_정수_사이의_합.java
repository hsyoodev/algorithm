package programmers.lv1;

import java.util.stream.LongStream;

public class P12912_두_정수_사이의_합 {

    public static void main(String[] args) {
        System.out.print(solution(3, 3));
    }

    public static long solution(int a, int b) {
        int seed = Math.min(a, b);
        int maxSize = Math.abs(b - a) + 1;

        return LongStream.iterate(seed, f -> f + 1).limit(maxSize).sum();
    }

}
