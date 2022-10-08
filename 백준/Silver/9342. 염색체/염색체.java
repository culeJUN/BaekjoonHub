import java.io.*;

public class Main {
    static String word;
    static char[] chars = new char[200];
    static char[] words = {'A', 'B', 'C', 'D', 'E', 'F'};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 한 단어마다
        for (int t = 0; t < T; t++) {
            word = br.readLine();
            chars = word.toCharArray();
            boolean isAcceptable = true;
            boolean checkA = false;
            boolean checkF = false;
            boolean checkC = false;
            boolean checkFinish = false;
            boolean[] checkOne = {false, false, false, false, false, false};

            // 한 글자마다
            for (int i = 0; i < word.length(); i++) {
                boolean flag = false;

                for (int j = 0; j < words.length; j++) {
                    if (chars[i] == words[j]) {
                        if (checkFinish && words[j] != 'C') {
                            if (checkOne[j] == true) {
                                flag = false;
                            }
                            else {
                                checkOne[j] = true;
                            }
                        }
                        else {
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag) {
                    System.out.println("Good");
                    isAcceptable = false;
                    break;
                }

                if (chars[i] == 'A') {
                    checkA = true;
                }
                else if (chars[i] == 'F') {
                    if (checkA == true) {
                        checkF = true;
                    }
                    else {
                        System.out.println("Good");
                        isAcceptable = false;
                        break;
                    }
                }
                else if (chars[i] == 'C') {
                    if (checkA == true && checkF == true) {
                        checkC = true;
                        checkFinish = true;
                    }
                    else {
                        System.out.println("Good");
                        isAcceptable = false;
                        break;
                    }
                }
                else {
                    continue;
                }
            }

            if (checkA && checkF && checkC && isAcceptable) {
                System.out.println("Infected!");
            }
        }
    }
}
