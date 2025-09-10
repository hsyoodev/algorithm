package programmers.lv1;

public class P134240_푸드_파이트_대회 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6}));
        System.out.print(solution(new int[]{1, 7, 1, 2}));
    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            sb.append(String.valueOf(i).repeat(food[i] / 2));
        }

        return sb.toString() + "0" + sb.reverse().toString();
    }

}
