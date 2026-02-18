package baekjoon.gold;

import java.util.*;

public class P1744_수_묶기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        boolean hasZero = false;

        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();

            if (number > 0) {
                positive.add(number);
            } else if (number < 0) {
                negative.add(number);
            } else {
                hasZero = true;
            }
        }

        Collections.sort(negative);
        Collections.sort(positive, Comparator.reverseOrder());

        long answer = 0;

        if (negative.size() % 2 == 1) {
            if (!hasZero) {
                answer += negative.get(negative.size() - 1);
            }

            negative.remove(negative.size() - 1);
        }

        if (positive.size() % 2 == 1) {
            answer += positive.get(positive.size() - 1);
            positive.remove(positive.size() - 1);
        }

        for (int i = 0; i < negative.size(); i += 2) {
            int A = negative.get(i);
            int B = negative.get(i + 1);

            answer += (A * B);
        }

        for (int i = 0; i < positive.size(); i += 2) {
            int A = positive.get(i);
            int B = positive.get(i + 1);

            if (B == 1) {
                answer += (A + B);
            } else {
                answer += (A * B);
            }
        }

        System.out.print(answer);
    }

}
