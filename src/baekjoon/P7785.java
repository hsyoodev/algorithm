package baekjoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/7785
public class P7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출입 기록의 수
        int n = Integer.parseInt(bufferedReader.readLine());
        // 출입 기록
        Map<String, String> records = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            records.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
        }
        // 현재 회사에 있는 사람의 이름
        List<String> names = new ArrayList<>();
        for (String key : records.keySet()) {
            if (records.get(key).equals("enter")) {
                names.add(key);
            }
        }
        // 사전 순의 역순으로
        names.sort(Collections.reverseOrder());
        for (String name : names) {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
