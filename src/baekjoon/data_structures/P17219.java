package baekjoon.data_structures;

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
        // 메모장에 사이트의 주소와 비밀번호를 저장
        Map<String, String> notepad = new HashMap<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            notepad.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
        }
        // 메모장에서 비밀번호를 찾아주기
        for (int i = 0; i < M; i++) {
            bufferedWriter.write(notepad.get(bufferedReader.readLine()));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
