package baekjoon.sorting;

import java.io.*;
import java.util.Arrays;

public class 수정렬하기3_10989 {
    private static int[] numbers;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        radixsort();
        for (int i = 0; i < N; i++) {
            bw.write(numbers[i] + "\n");
        }
        bw.flush();
    }

    private static void radixsort() {
        int[] outputs = new int[N];
        for (int digit = 1; digit <= 10000; digit *= 10) {
            int[] digitCounts = new int[10];
            for (int i = 0; i < N; i++) {
                digitCounts[(numbers[i] / digit) % 10]++;
            }
            Arrays.parallelPrefix(digitCounts, Integer::sum);
            for (int i = N - 1; i >= 0; i--) {
                outputs[digitCounts[(numbers[i] / digit) % 10] - 1] = numbers[i];
                digitCounts[(numbers[i] / digit) % 10]--;
            }
            System.arraycopy(outputs, 0, numbers, 0, N);
        }
    }
}
