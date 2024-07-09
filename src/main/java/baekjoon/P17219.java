package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17219
public class P17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        // 저장된 사이트 주소의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 비밀번호를 찾으려는 사이트 주소의 수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        Map<String, String> notepad = new HashMap<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            // 저장할 사이트 주소
            String url = stringTokenizer.nextToken();
            // 저장할 비밀번호
            String password = stringTokenizer.nextToken();
            notepad.put(url, password);
        }
        for (int i = 0; i < M; i++) {
            // 비밀번호를 찾으려는 사이트 주소
            String url = bufferedReader.readLine();
            // 사이트 주소의 비밀번호
            bufferedWriter.write(notepad.get(url));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
