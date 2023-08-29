package baekjoon.sorting;

import java.io.*;
import java.util.StringTokenizer;

public class K번째수_11004 {
    // N개의 수들 int[] A
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 수의 위치 K
        int K = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        // A 초기화
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // 퀵 정렬
        quicksort(1, N - 1, 0, K);
        // K번째 있는 수 출력
        bw.write(String.valueOf(A[K]));
        bw.flush();
    }
    // 퀵 정렬
    // 기준값 pivot을 정해 pivot보다 작은 데이터와 큰 데이터로 분류하여 정렬
    private static void quicksort(int s, int e, int p, int k){
        // 시작 위치가 끝 위치보다 클 경우
        if (s > e) {
            return;
        }
        // 시작 위치
        int startIdx = s;
        // 끝 위치
        int endIdx = e;
        // 기준값 위치
        int pivotIdx = p;
        // 작은데이터와 큰데이터 분류
        while (startIdx < endIdx) {
            if (A[startIdx] > A[pivotIdx] && A[endIdx] < A[pivotIdx]) {
                int temp = A[startIdx];
                A[startIdx] = A[endIdx];
                A[endIdx] = temp;
                startIdx++;
                endIdx--;
            } else {
                if (A[startIdx] <= A[pivotIdx]) {
                    startIdx++;
                }
                if (A[endIdx] >= A[pivotIdx]) {
                    endIdx--;
                }
            }
        }
        // swap
        int insertNum = A[pivotIdx];
        int insertIdx = insertNum > A[startIdx] ? startIdx : startIdx - 1;
        for (int i = pivotIdx; i < insertIdx; i++) {
            A[i] = A[i + 1];
        }
        A[insertIdx] = insertNum;

        // 삽입한 위치가 k와 같다면 재귀 종료, 같지 않다면 재귀 호출
        if (insertIdx == k) {
            return;
        } else if (insertIdx > k) {
            quicksort(s, insertIdx - 1, s - 1, k);
        } else {
            quicksort(insertIdx + 2, e, insertIdx + 1, k);
        }
    }
}


//    private static int[] A = {42, 32, 24, 60, 15, 5, 90, 45};
//
//    public static void main(String[] args) {
//        quicksort(1, A.length - 1, 0);
//
//        System.out.println(Arrays.toString(A));
//    }
//    private static void quicksort(int s, int e, int p){
//        int startIdx = s;
//        int endIdx = e;
//        int pivotIdx = p;
//
//        if (startIdx > endIdx) {
//            return;
//        }
//
//        while (startIdx < endIdx) {
//            if (A[startIdx] < A[pivotIdx]) {
//                startIdx++;
//            }
//            if (A[endIdx] > A[pivotIdx]) {
//                endIdx--;
//            }
//            if (A[startIdx] > A[pivotIdx] && A[endIdx] < A[pivotIdx]) {
//                int temp = A[startIdx];
//                A[startIdx] = A[endIdx];
//                A[endIdx] = temp;
//                startIdx++;
//                endIdx--;
//            }
//        }
//        int insertIdx = startIdx;
//        if (A[pivotIdx] > A[insertIdx]) {
//            for (int i = pivotIdx; i < insertIdx; i++) {
//                A[i] = A[i + 1];
//            }
//            A[insertIdx] = A[pivotIdx];
//        }
//        quicksort(s, insertIdx - 1, s - 1);
//        quicksort(insertIdx + 2, e, insertIdx + 1);
//    }