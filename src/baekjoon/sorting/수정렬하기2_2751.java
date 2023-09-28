package baekjoon.sorting;

import java.io.*;

public class 수정렬하기2_2751 {
    private static int[] numbers;
    private static int[] temps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        numbers = new int[N + 1];
        temps = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        mergesort(1, N);
        for (int i = 1; i < N + 1; i++) {
            bw.write(numbers[i] + "\n");
        }
        bw.flush();
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
            temps[tempsIndex++] = numbers[isMoveStartIndex1 ? moveStartIndex1++ : moveStartIndex2++];
        }
        for (int j = startIndex; j <= endIndex; j++) {
            numbers[j] = temps[j];
        }
    }
}