package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9375
public class P9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트 케이스
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            // 의상의 수
            int n = Integer.parseInt(bufferedReader.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String clotheName = stringTokenizer.nextToken();
                String clotheType = stringTokenizer.nextToken();
                clothes.put(clotheType, clothes.getOrDefault(clotheType, 0) + 1);
            }
            int answer = 1;
            for (int value : clothes.values()) {
                answer *= (value + 1);
            }
            bufferedWriter.write(n == 0 ? "0" : String.valueOf(answer - 1));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
