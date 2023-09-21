package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int startIndex = 0;
            int endIndex = N - 1;
            while (startIndex < endIndex) {
                if (startIndex == i) {
                    startIndex++;
                } else if (endIndex == i) {
                    endIndex--;
                } else {
                    int sum = numbers[startIndex] + numbers[endIndex];
                    if (sum < numbers[i]) {
                        startIndex++;
                    } else if (sum == numbers[i]) {
                        answer++;
                        break;
                    } else {
                        endIndex--;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
