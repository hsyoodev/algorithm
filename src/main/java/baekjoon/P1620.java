package baekjoon;

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
        // 도감에 수록되어 있는 포켓몬의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 내가 맞춰야 하는 문제의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 알파벳으로만 들어오면 포켓몬 번호
        Map<String, String> names = new HashMap<>();
        // 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자
        Map<String, String> numbers = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = bufferedReader.readLine();
            String number = String.valueOf(i);
            names.put(name, number);
            numbers.put(number, name);
        }
        // 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력
        for (int i = 0; i < M; i++) {
            String quiz = bufferedReader.readLine();
            String ansmwer = names.containsKey(quiz) ? names.get(quiz) : numbers.get(quiz);
            bufferedWriter.write(ansmwer);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
