package baekjoon.sorting;

import java.io.*;
import java.util.StringTokenizer;

public class K번째수_11004 {
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quicksort(1, N - 1, 0, K);
        bw.write(String.valueOf(A[K]));
        bw.flush();
    }
    private static void quicksort(int s, int e, int p, int k){
        if (s > e) {
            return;
        }

        int startIdx = s;
        int endIdx = e;
        int pivotIdx = p;
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
        int insertNum = A[pivotIdx];
        int insertIdx = insertNum > A[startIdx] ? startIdx : startIdx - 1;
        for (int i = pivotIdx; i < insertIdx; i++) {
            A[i] = A[i + 1];
        }
        A[insertIdx] = insertNum;

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