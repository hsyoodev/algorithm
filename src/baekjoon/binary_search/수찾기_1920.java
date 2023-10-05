package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기_1920 {
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int targetNumber = Integer.parseInt(st.nextToken());
            binarySearch(0, N - 1, targetNumber);
        }
    }
    static void binarySearch(int startIndex, int endIndex, int targetNumber) {
        if (startIndex > endIndex) {
            System.out.println(0);
            return;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        int middleNumber = numbers[middleIndex];
        if (middleNumber == targetNumber) {
            System.out.println(1);
        } else if (middleNumber > targetNumber){
            binarySearch(startIndex, middleIndex - 1, targetNumber);
        } else {
            binarySearch(middleIndex + 1, endIndex, targetNumber);
        }
    }
}