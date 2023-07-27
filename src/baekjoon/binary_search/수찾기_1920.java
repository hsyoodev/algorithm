package baekjoon.binary_search;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기_1920 {
    private static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(0, A.length - 1, sc.nextInt()));
        }
    }

    private static int binarySearch(int start, int end, int target) {
        if (start > end) {
            return 0;
        }
        int middle = (end + start) / 2;
        int value = A[middle];
        if (value == target) {
            return 1;
        } else if (value < target) {
            return binarySearch(middle + 1, end, target);
        } else {
            return binarySearch(0, middle - 1, target);
        }
    }
}