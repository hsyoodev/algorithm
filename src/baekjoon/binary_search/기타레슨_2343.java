package baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
    static int N;
    static int M;
    static int[] numbers;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        int max = -1;
        int sum = 0;
        for (int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            if (max < numbers[i]) {
                max = numbers[i];
            }
            sum += numbers[i];
        }
        bianrySearch(max, sum);
        System.out.print(answer);
    }

    static void bianrySearch(int startValue, int endValue) {
        if (startValue > endValue) {
            return;
        }
        int middleValue = (startValue + endValue) / 2;
        int sum = 0;
        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (sum + numbers[i] > middleValue) {
                count++;
                sum = 0;
            }
            sum += numbers[i];
        }
        if (M >= ++count) {
            answer = middleValue;
            bianrySearch(startValue, middleValue - 1);
        } else {
            bianrySearch(middleValue + 1, endValue);
        }
    }
}
