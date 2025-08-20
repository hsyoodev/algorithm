package programmers.lv1;

public class P68935_3진법_뒤집기 {

    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.print(solution(125));
    }

    public static int solution(int n) {
        String n3 = Integer.toString(n, 3);
        String filpN3 = new StringBuilder(n3).reverse().toString();

        return Integer.parseInt(filpN3, 3);
    }

}
