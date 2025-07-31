package programmers.lv1;

import java.util.List;

public class P12919_서울에서_김서방_찾기 {

    public static void main(String[] args) {
        System.out.print(solution(new String[]{"Jane", "Kim"}));
    }

    public static String solution(String[] seoul) {
        return "김서방은 " + List.of(seoul).indexOf("Kim") + "에 있다";
    }

}
