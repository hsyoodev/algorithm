package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수_11004 {
    private static int[] numbers;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        quicksort(0, N - 1);
        System.out.print(numbers[K]);
    }

    private static void quicksort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int insertIndex = partition(startIndex, endIndex);
            if (insertIndex == K) {
                return;
            } else if (insertIndex > K) {
                quicksort(startIndex, insertIndex - 1);
            } else {
                quicksort(insertIndex + 1, endIndex);
            }
        }
    }

    private static int partition(int startIndex, int endIndex) {
        if (startIndex + 1 == endIndex) {
            if (numbers[startIndex] > numbers[endIndex]) {
                swap(startIndex, endIndex);
            }
            return endIndex;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        swap(startIndex, middleIndex);
        int moveStartIndex = startIndex + 1;
        int moveEndIndex = endIndex;
        int pivot = numbers[startIndex];
        while (moveStartIndex <= moveEndIndex) {
            while (pivot > numbers[moveStartIndex] && moveStartIndex < numbers.length - 1) {
                moveStartIndex++;
            }
            while (pivot < numbers[moveEndIndex] && moveEndIndex > 0) {
                moveEndIndex--;
            }
            if (moveStartIndex <= moveEndIndex) {
                swap(moveStartIndex++, moveEndIndex--);
            }
        }
        numbers[startIndex] = numbers[moveEndIndex];
        numbers[moveEndIndex] = pivot;
        return moveEndIndex;
    }

    private static void swap(int swapIndex1, int swapIndex2) {
        int temp = numbers[swapIndex1];
        numbers[swapIndex1] = numbers[swapIndex2];
        numbers[swapIndex2] = temp;
    }
}