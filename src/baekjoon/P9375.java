package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9375
public class P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            // 의상의 수
            int n = Integer.parseInt(bufferedReader.readLine());
            // 해빈이가 가진 의상의 이름과 의상의 종류
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String name = stringTokenizer.nextToken();
                String category = stringTokenizer.nextToken();
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            int answer = 1;
            for (int count : map.values()) {
                answer *= (count + 1);
            }
            System.out.println(n == 0 ? 0 : answer - 1);
        }
        bufferedReader.close();
    }
}
