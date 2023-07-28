package baekjoon.greedy;

import java.util.Scanner;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split("-");
        int answer = 0;
        for (int i = 0; i < strs.length; i++) {
            int sum = sum(strs[i]);
            answer += (i == 0 ? 1 : -1) * sum;
        }
        System.out.print(answer);
    }
    private static int sum(String str) {
        int sum = 0;
        String[] strs = str.split("\\+");
        for (int i = 0; i < strs.length; i++) {
            sum += Integer.parseInt(strs[i]);
        }
        return sum;
    }
}

// 처음 풀이 방식
//        String[] S = sc.nextLine().replace("-"," - ")
//                                  .replace("+", " ")
//                                  .split(" ");
//        int sum = 0;
//        boolean add = true;
//        for (int i = 0; i < S.length; i++) {
//            if (S[i].equals("-")) {
//                add = false;
//                continue;
//            }
//            sum += (add ? 1 : -1) * Integer.parseInt(S[i]);
//        }
//        System.out.print(sum);