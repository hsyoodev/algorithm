package programmers.lv1;

public class P389478_택배_상자_꺼내기 {

    public static void main(String[] args) {
        System.out.println(solution(22, 6, 8));
        System.out.print(solution(13, 3, 6));
    }

    public static int solution(int n, int w, int num) {
        int[][] boxes = new int[w][((n - 1) / w) + 1];

        /*
         * 택배 상지 배치
         * i : 층수
         * k : 택배 상자 번호
         * j : 택배 상자 위치
         */
        for (int i = 1, k = 1; i <= ((n - 1) / w) + 1; i++) {
            if (i % 2 == 1) {
                for (int j = 0; j < w; j++) {
                    if (k > n) {
                        break;
                    }

                    boxes[j][i - 1] = k++;
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    if (k > n) {
                        break;
                    }

                    boxes[j][i - 1] = k++;
                }
            }
        }

        /*
         * 택배 상자 꺼내기
         */
        int answer = 0;

        for (int[] box : boxes) {
            int targetIndex = -1;

            for (int j = 0; j < box.length; j++) {
                if (box[j] == num) {
                    targetIndex = j;
                }
            }

            if (targetIndex != -1) {
                for (int j = targetIndex; j < box.length; j++) {
                    if (box[j] >= num) {
                        answer++;
                    }
                }

                break;
            }
        }

        return answer;
    }

}
