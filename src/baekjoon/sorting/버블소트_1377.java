package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 버블소트_1377 {
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        boolean changed = false;
        for (int i = 1; i <= N + 1; i++) {
            changed = false;
            for (int j = 1; j <= N - i; j++) {
                if (A[j] > A[j + 1]) {
                    changed = true;
                    swap(j);
                }
            }
            if (changed == false) {
                System.out.print(i);
                break;
            }
        }
    }
    public static void swap(int j) {
        int temp = A[j];
        A[j] = A[j + 1];
        A[j + 1] = temp;
    }
}
