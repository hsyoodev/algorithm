package baekjoon.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class 소트인사이드_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = scanner.next().chars()
                                      .map(e -> e - '0')
                                      .toArray();
        for (int i = 0; i < numbers.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > numbers[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[maxIndex];
                numbers[maxIndex] = temp;
            }
        }
        Arrays.stream(numbers).forEach(System.out::print);
    }
}
