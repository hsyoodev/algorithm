package programmers.lv1;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class P136798_기사단원의_무기 {

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
        System.out.print(solution(10, 3, 2));
    }

    public static int solution(int number, int limit, int power) {
        return IntStream.range(1, number + 1)
                .map(n -> {
                    int divisorCount = getDivisorCount(n);

                    if (divisorCount > limit) {
                        return power;
                    }

                    return divisorCount;
                })
                .sum();
    }

    public static int getDivisorCount(int number) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                set.add(i);
                set.add(number / i);
            }
        }

        return set.size();
    }

}
