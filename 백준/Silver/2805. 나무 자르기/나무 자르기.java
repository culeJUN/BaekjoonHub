// 2805 실버2 나무 자르기

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] logs = new int[N];
        long start = 0;
        long end = 0;
        long mid = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            logs[i] = Integer.parseInt(st.nextToken());
            end = end < logs[i] ? logs[i] : end;
        }

        while (start < end) {
            long count = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (mid < logs[i]) {
                    count += logs[i] - mid;
                }
            }

            if (count < M) {
                end = mid;
            }
            else {
                start = mid + 1 ;
            }
        }

        System.out.println(start - 1);
    }
}