package programmers.lv1;

public class P12930_이상한_문자_만들기 {

    public static void main(String[] args) {
        System.out.print(solution("try hello world"));
    }

    public static String solution(String s) {
        String[] characters = s.split("");
        int index = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i].equals(" ")) {
                index = 0;

                continue;
            }

            characters[i] = (index++ % 2 == 0) ? characters[i].toUpperCase() : characters[i].toLowerCase();
        }

        return String.join("", characters);
    }

}
