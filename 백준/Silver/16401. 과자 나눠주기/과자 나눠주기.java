// 16401 실버2 과자 나눠주기

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] cookies = new int[N];

        int start = 1;
        int end = 0;
        int mid = 0;
        int result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
            end = end > cookies[i] ? end : cookies[i];
        }

        while (start <= end) {
            mid = (start + end) / 2;
            int count = 0;

            for (int i = 0; i < N; i++) {
                count += cookies[i] / mid;
            }

            if (count >= M) {
                if (result < mid) {
                    result = mid;
                }
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}