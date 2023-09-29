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

    static void quicksort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(startIndex, endIndex);
            if (pivotIndex == K) {
                return;
            } else if (pivotIndex > K) {
                quicksort(startIndex, pivotIndex - 1);
            } else {
                quicksort(pivotIndex + 1, endIndex);
            }
        }
    }

    static int partition(int startIndex, int endIndex) {
        if (startIndex + 1 == endIndex) {
            if (numbers[startIndex] > numbers[endIndex]) {
                int temp = numbers[startIndex];
                numbers[startIndex] = numbers[endIndex];
                numbers[endIndex] = temp;
            }
            return endIndex;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        swap(middleIndex, startIndex);
        int pivotIndex = startIndex;
        int moveStartIndex = pivotIndex + 1;
        int moveEndIndex = endIndex;
        while (moveStartIndex < moveEndIndex) {
            while (numbers[moveStartIndex] < numbers[pivotIndex] && moveStartIndex < endIndex) {
                moveStartIndex++;
            }
            while (numbers[moveEndIndex] > numbers[pivotIndex] && moveEndIndex > startIndex + 1) {
                moveEndIndex--;
            }
            if (moveStartIndex < moveEndIndex) {
                swap(moveStartIndex++, moveEndIndex--);
            } else if (moveStartIndex == moveEndIndex) {
                if (numbers[pivotIndex] <= numbers[moveStartIndex]) {
                    moveEndIndex--;
                }
                moveStartIndex++;
            }
        }
        swap(pivotIndex, moveEndIndex);
        pivotIndex = moveEndIndex;
        return pivotIndex;
    }

    static void swap(int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}