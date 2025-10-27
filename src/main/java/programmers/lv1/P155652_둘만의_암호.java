package programmers.lv1;

public class P155652_둘만의_암호 {

    public static void main(String[] args) {
        System.out.print(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int count = 1; count <= index; ) {
                c = (c == 'z') ? 'a' : (char) (c + 1);

                if (!skip.contains(String.valueOf(c))) {
                    count++;
                }
            }

            answer.append(c);
        }

        return answer.toString();
    }

}
