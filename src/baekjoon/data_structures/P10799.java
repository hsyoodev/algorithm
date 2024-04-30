package baekjoon.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10799
public class P10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 쇠막대기와 레이저의 배치를 나타내는 괄호 표현
        String[] brackets = bufferedReader.readLine().split("");
        // 쇠막대기 수
        int ironBar = brackets[0].equals("(") ? 1 : 0;
        // 잘려진 쇠막대기 조각의 총 개수를 구하는
        int answer = 0;
        for (int i = 1; i < brackets.length; i++) {
            if (brackets[i].equals("(")) {
                ironBar++;
                continue;
            }
            ironBar--;
            answer += brackets[i - 1].equals("(") ? ironBar : 1;
        }
        System.out.print(answer);
    }
}
