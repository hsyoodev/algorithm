package baekjoon;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1966
public class P1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        // 테스트케이스의 수
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            // 문서의 개수
            int N = Integer.parseInt(stringTokenizer.nextToken());
            // 몇 번째로 인쇄되었는지 궁금한 문서
            int M = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            // 문서의 중요도
            PriorityQueue<Integer> prioritys = new PriorityQueue<>(Comparator.reverseOrder());
            // 인쇄하고자 하는 문서
            Queue<Document> documents = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(stringTokenizer.nextToken());
                prioritys.offer(priority);
                documents.offer(new Document(j, priority));
            }
            // 현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
            // 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다.
            while (!documents.isEmpty() && !prioritys.isEmpty()) {
                int priority = prioritys.poll();
                Document document = documents.poll();
                if (priority == document.priority) {
                    if (document.index == M) {
                        break;
                    }
                } else {
                    prioritys.offer(priority);
                    documents.offer(document);
                }
            }
            bufferedWriter.write(String.valueOf(N - documents.size()));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}

class Document {
    int index;
    int priority;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
