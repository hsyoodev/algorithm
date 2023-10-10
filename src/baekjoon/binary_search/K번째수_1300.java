package baekjoon.binary_search;

import java.util.Scanner;

public class K번째수_1300 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
//        binarySearch(i, N);
    }

    static void binarySearch(int startIndex, int endIndex) {
        int j = (startIndex + endIndex) / 2;
        int targetIndex = (i - 1) * N + j;
        if (targetIndex == K) {
            System.out.print(i * j);
        } else if (targetIndex < K) {
            binarySearch(j + 1, endIndex);
        } else {
            binarySearch(startIndex, j - 1);
        }
    }
}