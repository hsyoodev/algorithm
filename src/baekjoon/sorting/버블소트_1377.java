package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트_1377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];
        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(A);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int diff = A[i].index - i;
            if (max < diff) {
                max = diff;
            }
        }
        System.out.print(max + 1);
    }
}
class mData implements Comparable<mData> {
    public int value;
    public int index;

    public mData(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o) {
        return this.value - o.value;
    }
}
