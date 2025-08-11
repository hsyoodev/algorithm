package programmers.lv1;

public class P82612_부족한_금액_계산하기 {

    public static void main(String[] args) {
        System.out.print(solution(3, 20, 4));
    }

    public static long solution(long price, long money, long count) {
        return Math.max(0, count * (price + (price * count)) / 2 - money);
    }

}
