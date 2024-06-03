package baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10815
public class P10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 숫자 카드의 개수
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(stringTokenizer.nextToken());
        }
        // 숫자 카드인지 아닌지를 구해야하는 개수
        int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을
        for (int i = 0; i < M; i++) {
            bufferedWriter.write(set.contains(stringTokenizer.nextToken()) ? "1 " : "0 ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
