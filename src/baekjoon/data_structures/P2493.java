package baekjoon.data_structures;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2493
public class P2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 탑의 수
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Stack<Top> tops = new Stack<>();
        for (int i = 0; i < N; i++) {
            Top top = new Top(i + 1, Integer.parseInt(stringTokenizer.nextToken()));
            while (!tops.isEmpty()) {
                if (tops.peek().height < top.height) {
                    tops.pop();
                }
                // 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호
                else {
                    bufferedWriter.write(tops.peek().index + " ");
                    break;
                }
            }
            // 레이저 신호를 수신하는 탑이 존재하지 않으면 0을 출력
            if (tops.isEmpty()) {
                bufferedWriter.write("0 ");
            }
            tops.push(top);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class Top {
    int index;
    int height;

    Top(int index, int number) {
        this.index = index;
        this.height = number;
    }
}
