package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽_1940 {
    public static void main(String[] args) throws IOException {
        // 입력받을 데이터가 많아서 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 재료의 개수 N(1 <= N <= 15000) 제한시간 2초 On^2으로 풀수없는 문제
        int N = Integer.parseInt(br.readLine());
        // 갑옷을 만드는데 필요한 수 M
        int M = Integer.parseInt(br.readLine());
        // N개의 재료들 A
        int[] A = new int[N];
        // 문자열을 공백 단위로 나눠서 가져오기위해 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());
        // A 초기화
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // A 오름차순 정렬
        Arrays.sort(A);
        // 시작 인덱스
        int start = 0;
        // 끝 인덱스
        int end = N - 1;
        // 고유한 번호들의 합
        int sum = 0;
        // 갑옷을 만들 수 있는 개수
        int answer = 0;
        while (start < end) {
            sum = A[start] + A[end];
            if (sum < M) {
                start++;
            } else if (sum == M) {
                start++;
                end--;
                answer++;
            } else {
                end--;
            }
        }
        System.out.print(answer);
    }
}
