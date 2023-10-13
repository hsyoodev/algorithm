package SWEA.D1;

import java.util.Arrays;
import java.util.Scanner;

public class 중간값찾기_2063 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        System.out.print(numbers[N / 2]);
    }
}
