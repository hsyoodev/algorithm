package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14425
public class P14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 문자열의 개수 N과 M
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 문자열로 이루어진 집합 S
        String[] S = new String[N];
        for (int i = 0; i < N; i++) {
            S[i] = bufferedReader.readLine();
        }
        // M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지
        int answer = 0;
        for (int i = 0; i < M; i++) {
            String str = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                if (S[j].equals(str)) {
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}
