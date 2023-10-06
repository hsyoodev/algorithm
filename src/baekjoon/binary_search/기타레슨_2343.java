package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        int max = -1;
        for (int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        Arrays.parallelPrefix(numbers, Integer::sum);
        for (int i = 1; i < N; i++) {
            if (numbers[i] >= max) {

            }
        }


    }

    static void binarySearch(int startIndex, int endIndex) {





    }
}
