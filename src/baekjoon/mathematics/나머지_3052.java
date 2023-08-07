package baekjoon.mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class 나머지_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] intArr = new int[42];
        for (int i = 0; i < 10; i++) {
            int A = sc.nextInt();
            if (intArr[A % 42] != 1) {
                intArr[A % 42] = 1;
            }
        }
        System.out.print(Arrays.stream(intArr).filter(value -> value == 1).count());
    }
}
