package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수의 개수
        int N = Integer.parseInt(br.readLine());
        // N개의 숫자들 A
        int[] A = new int[N];
        // 문자열 공백 단위로 나누기
        StringTokenizer st = new StringTokenizer(br.readLine());
        // A 초기화
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // A 오름차순 정렬
        Arrays.sort(A);
        // 다른 수 두개의 합
        int sum = 0;
        // 좋은 수의 개수
        int answer = 0;
        for (int i = 0; i < N; i++) {
            // 시작 인덱스
            int start = 0;
            // 끝 인덱스
            int end = N - 1;
            while (start < end) {
                if (start == i) {
                    start++;
                } else if (end == i) {
                    end--;
                } else {
                    sum = A[start] + A[end];
                    if (sum < A[i]) {
                        start++;
                    } else if (sum == A[i]) {
                        answer++;
                        break;
                    } else {
                        end--;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
