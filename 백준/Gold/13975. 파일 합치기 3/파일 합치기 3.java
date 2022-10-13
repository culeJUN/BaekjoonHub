// 13975 골드4 파일합치기3

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pQueue = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                pQueue.add(Long.parseLong(st.nextToken()));
            }

            long sum = 0;

            while (pQueue.size() > 1) {
                long temp = pQueue.poll() + pQueue.poll();
                sum += temp;
                pQueue.add(temp);
            }

            System.out.println(sum);
        }
    }
}
