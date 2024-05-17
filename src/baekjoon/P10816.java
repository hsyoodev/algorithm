package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10816
public class P10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 숫자 카드의 개수
        int N = Integer.parseInt(bufferedReader.readLine());
        // 숫자 카드에 적혀있는 정수 갯수
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        // 정수의 개수
        int M = Integer.parseInt(bufferedReader.readLine());
        // 각 수가 적힌 숫자 카드를 몇 개 가지고 있는지
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            bufferedWriter.write(!map.containsKey(number) ? "0" : String.valueOf(map.get(number)));
            bufferedWriter.write(" ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
