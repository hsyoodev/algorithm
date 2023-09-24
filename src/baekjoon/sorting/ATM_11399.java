package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
            int insertNumber = numbers[i];
            int insertIndex = i;
            for (int j = 0; j < i; j++) {
                if (insertNumber < numbers[j]) {
                    insertIndex = j;
                    break;
                }
            }
            if (insertIndex != i) {
                for (int j = i; j > insertIndex; j--) {
                    numbers[j] = numbers[j - 1];
                }
                numbers[insertIndex] = insertNumber;
            }
        }
        Arrays.parallelPrefix(numbers, Integer::sum);
        System.out.print(Arrays.stream(numbers).sum());
    }
}
