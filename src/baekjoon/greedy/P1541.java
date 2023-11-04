package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class P1541 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.next()
                        .replace("-", " -")
                        .replace("+", " +")
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int answer = 0;
        boolean isNegative = false;
        for (int number : numbers) {
            if (!isNegative) {
                isNegative = number < 0;
            }
            answer += number * (isNegative && number > 0 ? -1 : 1);
        }
        System.out.print(answer);
    }
}
