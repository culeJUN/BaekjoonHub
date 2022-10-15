// 1918 골드2 후위 표기식

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            switch(now) {
                case '+' :
                case '-' :
                case '*' :
                case '/' :
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {    // 스택 맨 아래의 우선순위가 지금 들어온거보다 크거나 같으면
                        sb.append(stack.pop());
                    }

                    stack.add(now);
                    break;

                case '(' :
                    stack.add(now);
                    break;

                case ')' :
                    while(!stack.isEmpty() && stack.peek() != '(') {    // ( 나올때까지 연산자 뺴줌
                        sb.append(stack.pop());
                    }

                    stack.pop();    // ( 빼주는 용
                    break;

                default :
                    sb.append(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    static int priority(char operator) {
        if (operator == '(' || operator == ')') {
            return 0;
        }
        else if (operator == '+' || operator == '-') {
            return 1;
        }
        else if (operator == '*' || operator == '/') {
            return 2;
        }

        return -1;
    }
}
