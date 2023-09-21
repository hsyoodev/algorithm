package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] uniqueNumber = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            uniqueNumber[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(uniqueNumber);
        int startIndex = 0;
        int endIndex = N - 1;
        int sum = 0;
        int answer = 0;
        while (startIndex < endIndex) {
            sum = uniqueNumber[startIndex] + uniqueNumber[endIndex];
            if (sum < M) {
                startIndex++;
            } else if (sum == M) {
                answer++;
                startIndex++;
                endIndex--;
            } else {
                endIndex--;
            }
        }
        System.out.print(answer);
    }
}
