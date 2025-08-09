package programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class P77884_약수의_개수와_덧셈 {

    public static void main(String[] args) {
        System.out.print(solution(13, 17));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            Set<Integer> divisors = new HashSet<>();

            for (int j = 1; j <= (i + 1) / 2; j++) {
                if (i % j == 0) {
                    divisors.add(j);
                    divisors.add(i / j);
                }
            }

            answer += divisors.size() % 2 == 0 ? i : -i;
        }

        return answer;
    }

}
