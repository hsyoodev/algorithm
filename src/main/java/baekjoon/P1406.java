package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.acmicpc.net/problem/1406
public class P1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 편집기에 입력되어 있는 문자열
        LinkedList<String> linkedList = Stream.of(bufferedReader.readLine().split(""))
                .collect(Collectors.toCollection(LinkedList::new));
        ListIterator<String> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        // 입력할 명령어의 개수
        int M = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            String[] order = bufferedReader.readLine().split(" ");
            switch (order[0]) {
                // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
                case "L":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    break;
                // 	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
                case "D":
                    if (listIterator.hasNext()) {
                        listIterator.next();
                    }
                    break;
                // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
                // 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
                case "B":
                    if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                // $라는 문자를 커서 왼쪽에 추가함
                case "P":
                    listIterator.add(order[1]);
                    break;
            }
        }
        System.out.print(String.join("", linkedList));
    }
}
