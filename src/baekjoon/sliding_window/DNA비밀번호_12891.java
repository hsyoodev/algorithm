package baekjoon.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA비밀번호_12891 {
    // 부분문자열에 포함되어야 할 {'A', 'C', 'G', 'T'}의 최소 개수 R
    private static int[] R = new int[4];
    // 부분문자열의 {'A', 'C', 'G', 'T'}의 개수 V
    private static int[] V = new int[4];
    // 비밀번호의 종류의 수 answer
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // DNA 문자열의 길이 S
        int S = Integer.parseInt(st.nextToken());
        // 부분문자열의 길이 M
        int M = Integer.parseInt(st.nextToken());
        // DNA 문자열 DNA
        String DNA = br.readLine();
        st = new StringTokenizer(br.readLine());
        // R 초기화
        for (int i = 0; i < 4; i++) {
            R[i] = Integer.parseInt(st.nextToken());
        }
        
        // 첫번째 0 ~ M 부분문자열 {'A', 'C', 'G', 'T'}의 개수 초기화
        for (int i = 0; i < M; i++) {
            V[getIndex(DNA.charAt(i))]++;
        }
        // 첫번째 0 ~ M 부분문자열 검증
        verify();

        // 시작 인덱스
        int start = 0;
        // 끝 인덱스
        int end = M - 1;
        // 두번째부터 앞뒤부분만 -, +하면서 부분문자열 검증
        for (int i = 1; i <= S - M; i++) {
            // 앞부분 -
            V[getIndex(DNA.charAt(start++))]--;
            // 뒷부분 +
            V[getIndex(DNA.charAt(++end))]++;
            // start ~ end 부분문자열 검증
            verify();
        }
        System.out.print(answer);
    }
    public static int getIndex(char c) {
        int index = -1;
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
    public static void verify() {
        int count = 0;
        for (int j = 0; j < 4; j++) {
            if (R[j] == V[j]) {
                count++;
            }
        }
        if (count == 4) {
            answer++;
        }
    }
}
