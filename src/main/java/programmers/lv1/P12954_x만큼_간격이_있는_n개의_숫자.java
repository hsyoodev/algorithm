package programmers.lv1;

import java.util.Arrays;
import java.util.stream.LongStream;

public class P12954_x만큼_간격이_있는_n개의_숫자 {

    public static void main(String[] args) {
        System.out.print(Arrays.toString(solution(2, 5)));
    }

    public static long[] solution(int x, int n) {
        return LongStream.iterate(x, i -> x + i).limit(n).toArray();
    }

}
