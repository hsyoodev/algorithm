package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수의 개수 N
        int N = Integer.parseInt(br.readLine());
        // N개의 수를 저장할 배열 A
        int[] A = new int[N];
        // A 초기화
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        // N번 반복
        for (int i = 0; i < N - 1; i++) {
            // 버블 정렬
            for (int j = 0; j < N - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        Arrays.stream(A).forEach(System.out::println);
    }
}
