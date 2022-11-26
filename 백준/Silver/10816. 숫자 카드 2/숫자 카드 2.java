// 10816 실버4 숫자 카드 2

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append((highArrayIdx(key) - lowArrayIdx(key)) + " ");
        }
        
        System.out.println(sb);
    }

    static int lowArrayIdx(int key) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = (start + end) / 2;

            // 같으면 뒤를 땡기면서 key만 남도록 좁힘
            if (key <= cards[mid]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int highArrayIdx(int key) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = (start + end) / 2;

            // 같아도 앞을 땡기면서 key 바로 다음 인덱스로 좁힘
            if (key < cards[mid]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}