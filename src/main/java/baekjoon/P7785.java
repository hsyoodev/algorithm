package baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// https://www.acmicpc.net/problem/7785
public class P7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출입 기록의 수
        int n = Integer.parseInt(bufferedReader.readLine());
        // 출근 명단
        Set<String> names = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String name = stringTokenizer.nextToken();
            boolean isEnter = stringTokenizer.nextToken().equals("enter");
            if (isEnter) {
                names.add(name);
            } else {
                names.remove(name);
            }
        }
        for (String name : names) {
            bufferedWriter.write(name);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
