package baekjoon.sorting;

import java.io.*;
import java.util.StringTokenizer;

public class K번째수_11004 {
    private static int[] numbers;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        quicksort(1, N - 1, 0);
        bw.write(String.valueOf(numbers[K]));
        bw.flush();
    }
    private static void quicksort(int s, int e, int p){
        if (s > e) {
            return;
        }
        int startIdx = s;
        int endIdx = e;
        int pivotIdx = p;
        while (startIdx < endIdx) {
            if (numbers[startIdx] > numbers[pivotIdx] && numbers[endIdx] < numbers[pivotIdx]) {
                int temp = numbers[startIdx];
                numbers[startIdx] = numbers[endIdx];
                numbers[endIdx] = temp;
                startIdx++;
                endIdx--;
            } else {
                if (numbers[startIdx] <= numbers[pivotIdx]) {
                    startIdx++;
                }
                if (numbers[endIdx] >= numbers[pivotIdx]) {
                    endIdx--;
                }
            }
        }
        int insertIdx = pivotIdx;
        if (numbers[pivotIdx] > numbers[endIdx]) {
            int temp = numbers[pivotIdx];
            for (int i = pivotIdx; i < endIdx; i++) {
                numbers[i] = numbers[i + 1];
            }
            numbers[endIdx] = temp;
            insertIdx = endIdx;
        }
        if (insertIdx == K) {
            return;
        } else if (insertIdx > K) {
            quicksort(s, endIdx - 1, s - 1);
        } else {
            quicksort(insertIdx + 2, e, insertIdx + 1);
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