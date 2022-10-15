// 2014 골드1 소수의 곱

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] prime = new long[k];
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            prime[i] = Integer.parseInt(st.nextToken());
            pQueue.add(prime[i]);
        }

        for (int i = 0; i < n - 1; i++) {  // n - 1인 이유는 아래를 보면 알 수 있다.
            long num = pQueue.poll();    // 이렇게 하면 작은거 순서대로 수를 뽑을 수 있다

            for (int j = 0; j < k; j++) {
                long mul = num * prime[j];
                pQueue.add(mul);         // 바로 정렬이 된다.

                if (num % prime[j] == 0) {      // 시간을 반으로 줄여준다. 2*5랑 5*2를 한번만 하게 해준다.
                    break;
                }
            }
        }

        System.out.println(pQueue.poll());   // n-1까지만 돌았으니까 그다음은 n번째로 작은 수가 나온다.
    }
}
