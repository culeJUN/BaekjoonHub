//4659 실버5 비밀번호 발음하기

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};  // 모음

        while (true) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            if (word.equals("end")) {
                break;
            }

            boolean acceptable = true;
            boolean hasVowel = false;   // 모음 있는지
            int cntVowel = 0;   // 모음 개수
            int cntConsonant = 0;   // 자음 개수

            for (int i = 0; i < word.length(); i++) {
                char nowChar = word.charAt(i);
                boolean isVowel = false;    // 자음 모음 숫자 세주기 위함

                // 모음인지 확인
                for (int j = 0; j < vowels.length; j++) {
                    // 모음이라면
                    if (nowChar == vowels[j]) {
                        hasVowel = true;
                        isVowel = true;
                        // 모음 연속 개수 + 1, 자음 연속 개수 초기화
                        cntVowel++;
                        cntConsonant = 0;
                        // 모음인거 찾았으니까 탈출
                        break;
                    }
                }
                // 자음이라면
                if (!isVowel) {
                    // 자음 연속 개수 + 1, 모음 연속 개수 초기화
                    cntConsonant++;
                    cntVowel = 0;
                }
                // 다 훑었을 경우
                if (i == word.length() - 1) {
                    if (!hasVowel) {
                        acceptable = false;
                        System.out.println("<" + word + "> is not acceptable.");
                        break;
                    }
                }

                if (i >= 1) {
                    if (nowChar == word.charAt(i - 1) && nowChar != 'o' && nowChar != 'e') {
                        acceptable = false;
                        System.out.println("<" + word + "> is not acceptable.");
                        break;
                    }
                    else if(cntVowel >= 3 || cntConsonant >= 3){
                        acceptable = false;
                        System.out.println("<" + word + "> is not acceptable.");
                        break;
                    }
                }
            }
            if (acceptable) {
                System.out.println("<" + word + "> is acceptable.");
            }
        }
    }
}
