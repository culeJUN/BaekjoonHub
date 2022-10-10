// 20437 골드5 문자열 게임2

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println("1 1");
                continue;
            }

            // 알파벳 개수를 각각 저장
            int[] alphabets = new int[26];

            for (int i = 0; i < str.length(); i++) {
                alphabets[str.charAt(i) - 'a']++;
            }

            int shortest = Integer.MAX_VALUE;
            int longest = Integer.MIN_VALUE;

            // 단어 안 글자 순환
            for (int i = 0; i < str.length(); i++) {
                // 애초에 해당 글자 수가 나와야 되는 글자 개수 보다 적으면 패스
                if (alphabets[str.charAt(i) - 'a'] < k) {
                    continue;
                }

                // 원하는 글자 개수 보다 많거나 같은 경우
                int cnt = 1;

                // i번째 글자랑 같은 글자 찾는거니까 i+1 부터 순회
                for (int j = i + 1; j < str.length(); j++) {
                    //j랑 i번째 같다면 찾은 글자수 +1
                    if (str.charAt(i) == str.charAt(j)) {
                        cnt++;
                    }
                    
                    //찾은 글자수랑 나와야 되는 글자 수 같으면 최단 최장 업데이트
                    if (cnt == k) {
                        shortest = Math.min(shortest, j - i + 1);
                        longest = Math.max(longest, j - i + 1);
                        // 브레이크 걸면 i번째 다음 글자부터 다시 순회 가능 -> 같은 알파벳이여도 다시 세준다
                        break;
                    }
                }
            }

            if (shortest == Integer.MAX_VALUE && longest == Integer.MIN_VALUE) {
                System.out.println("-1");
            }
            else {
                System.out.println(shortest + " " + longest);
            }
        }
    }
}
