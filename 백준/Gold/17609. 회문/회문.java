import java.io.*;

public class Main {
    static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String word = br.readLine();
            chars = new char[word.length()];

            for (int i = 0; i < word.length(); i++) {
                chars[i] = word.charAt(i);
            }

            int start = 0;
            int end = word.length() - 1;

            if (isPerfactPallindrome(start, end)) {
                System.out.println("0");
            }
            else if (isSimmilarPallindrome(start, end)) {
                System.out.println("1");
            }
            else {
                System.out.println("2");
            }

        }
    }

    static boolean isPerfactPallindrome(int start, int end) {
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    static boolean isSimmilarPallindrome(int start, int end) {
        boolean minusLeft;
        boolean minusRight;
        while (start < end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            }
            else {
                minusLeft = isPerfactPallindrome(start + 1, end);
                minusRight = isPerfactPallindrome(start, end - 1);
                if (minusLeft == false && minusRight == false) {
                    return false;
                }
                else {
                    return true;
                }
            }
        }
        return true;
    }
}
