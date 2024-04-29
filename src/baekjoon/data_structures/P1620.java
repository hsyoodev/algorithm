package baekjoon.data_structures;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1620
public class P1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 포켓몬의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 문제의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력
        Map<String, String> names = new HashMap<>();
        Map<String, String> numbers = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = bufferedReader.readLine();
            names.put(name, String.valueOf(i + 1));
            numbers.put(String.valueOf(i + 1), name);
        }
        // 내가 맞춰야하는 문제가 입력으로 들어와
        for (int i = 0; i < M; i++) {
            String question = bufferedReader.readLine();
            // 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고
            if (names.containsKey(question)) {
                bufferedWriter.write(names.get(question));
                bufferedWriter.newLine();
            }
            // 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력
            else {
                bufferedWriter.write(numbers.get(question));
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
    }
}
