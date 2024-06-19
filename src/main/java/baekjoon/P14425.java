package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14425
public class P14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 문자열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        Set<String> S = new HashSet<>();
        // S에 포함되어 있는 문자열들
        for (int i = 0; i < N; i++) {
            S.add(bufferedReader.readLine());
        }
        int answer = 0;
        // 검사해야 하는 문자열들
        for (int i = 0; i < M; i++) {
            if (S.contains(bufferedReader.readLine())) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}
