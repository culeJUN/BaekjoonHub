// 20210 골드2 파일 탐색기

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] str;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = s1.length();
                int len2 = s2.length();
                int i = 0, j = 0;

                for (; i < len1 && j < len2; i++, j++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(j);
                    // 숫자인지 확인
                    boolean isNumber1 = isNum(c1);
                    boolean isNumber2 = isNum(c2);

                    // 둘다 숫자인 경우
                    if (isNumber1 && isNumber2) {

                        // 숫자 앞 0의 개수 확인
                        int cnt1 = 0, cnt2 = 0;

                        while (i < s1.length() && '0' == s1.charAt(i)) {
                            // 글자 범위 안에서 뒤에 지금 글자가 0이라면 뒤로 커서 넘기고 0카운트 +1
                            cnt1++;
                            i++;
                        }

                        while (j < s2.length() && '0' == s2.charAt(j)) {
                            // 글자 범위 안에서 뒤에 지금 글자가 0이라면 뒤로 커서 넘기고 0카운트 +1
                            cnt2++;
                            j++;
                        }

                        i = i >= len1 ? len1 : i;
                        j = j >= len2 ? len2 : j;

                        //0을 제외한 숫자인 경우
                        StringBuilder sb1 = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();

                        while (i < s1.length() && '0' <= s1.charAt(i) && s1.charAt(i) <= '9') {
                            if ('0' <= s1.charAt(i) && s1.charAt(i) <= '9') {
                                sb1.append(s1.charAt(i));
                            }
                            i++;
                        }

                        while (j < s2.length() && '0' <= s2.charAt(j) && s2.charAt(j) <= '9') {
                            if ('0' <= s2.charAt(j) && s2.charAt(j) <= '9') {
                                sb2.append(s2.charAt(j));
                            }
                            j++;
                        }

                        i--;
                        j--;

                        // 0 제거 된 숫자만 남음 -> 길이가 일단 긴게 큰수
                        if (sb1.length() > sb2.length()) {
                            return 1;
                        }
                        if (sb2.length() > sb1.length()) {
                            return -1;
                        }

                        // 길이 같다면 한자리씩 비교
                        String num1 = sb1.toString();
                        String num2 = sb2.toString();

                        for (int a = 0, b = 0; a < num1.length() && b < num2.length(); a++, b++) {
                            if (num1.charAt(a) > num2.charAt(b)) {
                                return 1;
                            }
                            else if (num2.charAt(b) > num1.charAt(a)) {
                                return -1;
                            }
                        }

                        // 숫자가 똑같다면 앞에 0의 개수가 작은순
                        if (cnt1 != cnt2) {
                            return cnt1 - cnt2;
                        }
                    }

                    // 둘다 문자인 경우
                    if (!isNumber1 && !isNumber2) {
                        // 같은 문자 패스
                        if (c1 == c2) {
                            continue;
                        }

                        // 대소문자 판별
                        boolean isUpper1 = c1 - 'a' < 0 ? true : false;
                        boolean isUpper2 = c2 - 'a' < 0 ? true : false;

                        int n1 = c1 - 'a' >= 0 ? c1 - 'a' : c1 - 'A';
                        int n2 = c2 - 'a' >= 0 ? c2 - 'a' : c2 - 'A';

                        // 둘다 대문자 or 소문자
                        if ((isUpper1 && isUpper2) || (!isUpper1 && !isUpper2)) {
                            return n1 - n2;
                        }

                        // c1 소문자 c2 대문자
                        if (!isUpper1 && isUpper2) {
                            if (n1 == n2) {
                                return 1;
                            }
                            else {
                                return n1 - n2;
                            }
                        }

                        // c1 대문자 c2 소문자
                        if (isUpper1 && !isUpper2) {
                            if (n1 == n2) {
                                return -1;
                            }
                            else {
                                return n1 - n2;
                            }
                        }
                    }

                    // c1 문자 c2 숫자
                    if (!isNumber1 && isNumber2) {
                        return 1;
                    }

                    // c1 숫자 c2 문자
                    if (isNumber1 && !isNumber2) {
                        return -1;
                    }
                }

                // 같은 문자인데 뒤에 다른 문자열이 붙는 경우 더 긴 문자열이 뒤
                if (len1 != i) {
                    return 1;
                }

                if (len2 != j) {
                    return -1;
                }

                return 0;
            }
        });

        for (String s : str) {
            sb.append(s).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }
}
