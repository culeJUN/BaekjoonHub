// 9935 골드4 문자열 폭발

import javax.swing.plaf.basic.BasicViewportUI;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {
                boolean flag = true;

                for (int j = 0; j < bomb.length(); j++) {
                     if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        for (char ch : stack) {
            sb.append(ch);
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        }
        else {
            System.out.println(sb);
        }
    }
}
