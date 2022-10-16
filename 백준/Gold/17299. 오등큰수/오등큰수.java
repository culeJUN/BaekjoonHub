// 17299 골드3 오등큰수

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 수열의 길이
        int[] input = new int[N];                   //수열 저장할 배열
        int[] num = new int[1000001];               // 숫자 개수 저장할 배열
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            num[input[i]]++;
        }

        Stack<Integer> stack = new Stack<>();       // index 저장하는  stack

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && num[input[stack.peek()]] < num[input[i]]) {  // 큰거 나오는 순간
                input[stack.pop()] = input[i];      // 큰거로 수열 숫자 바꿔버리기 + 그 인덱스는 값을 바꿨으므로 stack에서 pop
            }

            stack.push(i);          // 자기 인덱스 추가
        }

        while (!stack.isEmpty()) {  // pop 안된 인덱스는 자기가 제일 크니까 -1로 바꿔주기
            input[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(input[i] + " ");
        }

        System.out.println(sb);
    }
}
