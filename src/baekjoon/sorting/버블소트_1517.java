package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 버블소트_1517 {
    private static int[] numbers;
    private static int[] temps;
    private static long swap = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[N + 1];
        temps = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        mergesort(1, N);
        System.out.print(swap);
    }

    private static void mergesort(int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return;
        }
        int splitEndIndex = ((startIndex + endIndex) / 2);
        int splitStartIndex = splitEndIndex + 1;
        mergesort(startIndex, splitEndIndex);
        mergesort(splitStartIndex, endIndex);
        int moveStartIndex1 = startIndex;
        int moveStartIndex2 = splitStartIndex;
        int tempsIndex = startIndex;
        while (tempsIndex <= endIndex) {
            boolean isMoveStartIndex1 = moveStartIndex2 > endIndex ||
                    (moveStartIndex1 < splitStartIndex &&
                            numbers[moveStartIndex1] <= numbers[moveStartIndex2]);
            if (!isMoveStartIndex1) {
                swap += moveStartIndex2 - tempsIndex;
            }
            temps[tempsIndex++] = numbers[isMoveStartIndex1 ? moveStartIndex1++ : moveStartIndex2++];
        }
        for (int j = startIndex; j <= endIndex; j++) {
            numbers[j] = temps[j];
        }
    }
}
