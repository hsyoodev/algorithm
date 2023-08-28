package baekjoon.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class 소트인사이드_1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 정렬하려고 하는 수 N
        String N = scanner.nextLine();
        // N to int[]할 A
        int[] A = new int[N.length()];
        // N to int[]
        for (int i = 0; i < N.length(); i++) {
            A[i] = N.charAt(i) - '0';
        }
        // 선택 정렬
        for (int i = 0; i < A.length; i++) {
            // 최댓값 위치 i로 초기화 maxIdx
            int maxIdx = i;
            // i 이외의 최댓값 위치 찾기
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] > A[maxIdx]) {
                    maxIdx = j;
                }
            }
            // i 위치와 다르면 swap
            if (i != maxIdx) {
                int temp = A[i];
                A[i] = A[maxIdx];
                A[maxIdx] = temp;
            }
        }
        // 정렬된 int[] A 출력
        Arrays.stream(A).forEach(System.out::print);
    }
}
