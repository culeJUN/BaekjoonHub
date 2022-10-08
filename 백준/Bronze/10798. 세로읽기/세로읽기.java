import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chars = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                chars[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (chars[j][i] == ' ' || chars[j][i] == '\0') {
                    continue;
                }
                else {
                    sb.append(chars[j][i]);
                }
            }
        }

        System.out.print(sb.toString());
    }
}
