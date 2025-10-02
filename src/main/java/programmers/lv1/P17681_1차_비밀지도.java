package programmers.lv1;

import java.util.Arrays;

public class P17681_1차_비밀지도 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.print(Arrays.toString(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] decrpytArr1 = new String[n];
        String[] decrpytArr2 = new String[n];
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            decrpytArr1[i] = Integer.toBinaryString(arr1[i]);
            decrpytArr2[i] = Integer.toBinaryString(arr2[i]);
            StringBuilder sb = new StringBuilder();

            while (decrpytArr1[i].length() < n) {
                decrpytArr1[i] = "0" + decrpytArr1[i];
            }

            while (decrpytArr2[i].length() < n) {
                decrpytArr2[i] = "0" + decrpytArr2[i];
            }

            for (int j = 0; j < n; j++) {
                if (decrpytArr1[i].charAt(j) == '1' || decrpytArr2[i].charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

}
