package programmers.lv1;

import java.util.stream.LongStream;

public class P82612_부족한_금액_계산하기 {

    public static void main(String[] args) {
        System.out.print(solution(3, 20, 4));
    }

    public static long solution(int price, int money, int count) {
        return Math.max(0, LongStream.range(1, count + 1).map(i -> i * price).sum() - money);
    }

}
