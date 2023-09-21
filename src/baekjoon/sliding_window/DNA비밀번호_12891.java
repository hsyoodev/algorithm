package baekjoon.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {
    // 부분문자열에 포함되어야 할 {'A', 'C', 'G', 'T'} 의 최소 개수
    private static int[] minCounts = new int[4];
    // 부분문자열의 {'A', 'C', 'G', 'T'}의 개수
    private static int[] counts = new int[4];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] DNA = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minCounts[i] = Integer.parseInt(st.nextToken());
        }
        // 첫 번째 0 ~ (P - 1) 부분문자열 검증
        for (int i = 0; i < P; i++) {
            counts[getIndex(DNA[i])]++;
        }
        verify();
        // 두 번째부터 앞뒤 부분만 -, +하면서 부분문자열 검증
        int startIndex = 0;
        int endIndex = P - 1;
        for (int i = 1; i <= S - P; i++) {
            counts[getIndex(DNA[startIndex++])]--;
            counts[getIndex(DNA[++endIndex])]++;
            verify();
        }
        System.out.print(answer);
    }

    private static int getIndex(char c) {
        // {'A', 'C', 'G', 'T'}의 index 반환
        int index;
        if (c == 'A') {
            index = 0;
        } else if (c == 'C') {
            index = 1;
        } else if (c == 'G') {
            index = 2;
        } else {
            index = 3;
        }
        return index;
    }

    private static void verify() {
        // {'A', 'C', 'G', 'T'} 검증
        int count = 0;
        for (int j = 0; j < 4; j++) {
            if (minCounts[j] <= counts[j]) {
                count++;
            }
        }
        if (count == 4) {
            answer++;
        }
    }
}
