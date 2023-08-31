package baekjoon.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISpeakTXTMSG_6841 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String shortForm = null;
        String translation = null;
        while (true) {
            shortForm = br.readLine();
            switch (shortForm) {
                case "CU":
                    translation = "see you";
                    break;
                case ":-)":
                    translation = "I’m happy";
                    break;
                case ":-(":
                    translation = "I’m unhappy";
                    break;
                case ";-)":
                    translation = "wink";
                    break;
                case ":-P":
                    translation = "stick out my tongue";
                    break;
                case "(~.~)":
                    translation = "sleepy";
                    break;
                case "TA":
                    translation = "totally awesome";
                    break;
                case "CCC":
                    translation = "Canadian Computing Competition";
                    break;
                case "CUZ":
                    translation = "because";
                    break;
                case "TY":
                    translation = "thank-you";
                    break;
                case "YW":
                    translation = "you’re welcome";
                    break;
                case "TTYL":
                    translation = "talk to you later";
                    break;
                default:
                    translation = shortForm;
                    break;
            }
            System.out.println(translation);
            if (shortForm.equals("TTYL")) {
                break;
            }
        }
    }
}
