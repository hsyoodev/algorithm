package programmers.lv1;

public class P12922_수박수박수박수박수박수 {

    public static void main(String[] args) {
        System.out.print(solution(3));
    }

    public static String solution(int n) {
        return "수박".repeat(n / 2) + (n % 2 == 0 ? "" : "수");
    }
    
}
