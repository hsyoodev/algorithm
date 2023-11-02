package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1744 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> positiveNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int numbers = scanner.nextInt();
            if (numbers <= 0) {
                negativeNumbers.add(numbers);
            } else {
                positiveNumbers.add(numbers);
            }
        }
        Collections.sort(negativeNumbers);
        Collections.sort(positiveNumbers, Collections.reverseOrder());
        System.out.print(getSum(negativeNumbers) + getSum(positiveNumbers));
    }

    static int getSum(List<Integer> numbers) {
        int sum = 0;
        int startIndex = 0;
        int endIndex = numbers.size() - 1;
        while (startIndex < endIndex) {
            int number1 = numbers.get(startIndex);
            int number2 = numbers.get(startIndex + 1);
            sum += Math.max(number1 * number2, number1 + number2);
            startIndex += 2;
        }
        // 수열의 크기가 홀수일 경우
        if (startIndex == endIndex) {
            sum += numbers.get(startIndex);
        }
        return sum;
    }
}
