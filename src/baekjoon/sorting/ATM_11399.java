package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 사람의 수 N
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 돈을 인출하는데 걸리는 시간들 int[] A
        int[] A = new int[N];
        // A 초기화
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 삽입할 숫자 insertNum
        int insertNum;
        // 삽입할 위치 insertIdx
        int insertIdx;
        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            insertNum = A[i];
            insertIdx = i;
            // 삽입할 위치 찾기
            for (int j = 0; j < i; j++) {
                if (insertNum < A[j]) {
                    insertIdx = j;
                    break;
                }
            }
            // 삽입할 위치 + 1부터 우측으로 한칸씩 이동
            for (int j = i; j > insertIdx; j--) {
                A[j] = A[j - 1];
            }
            // 삽입할 위치에 삽입할 숫자 할당
            A[insertIdx] = insertNum;
        }
        // 각 사람마다 돈을 인출하는데 필요한 시간 int[] S
        int[] S = new int[N];
        // S 초기화
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }
        // 각 사람마다 돈을 인출하는데 필요한 시간의 합의 최솟값
        System.out.print(Arrays.stream(S).sum());
    }
}
