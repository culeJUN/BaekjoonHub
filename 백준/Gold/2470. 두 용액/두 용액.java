// 2470 골드5 두 용액

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] liquid = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int i = 0;
        int j = N - 1;
        int liq1 = 0;
        int liq2 = 0;
        int sum = Integer.MAX_VALUE;

        while (i < j) {
            int temp = liquid[i] + liquid[j];

            if (sum > Math.abs(temp)) {
                sum = Math.abs(temp);
                liq1 = i;
                liq2 = j;
            }

            if (temp < 0) {
                i++;
            }
            else {
                j--;
            }
        }

        System.out.println(liquid[liq1] + " " + liquid[liq2]);
    }
}
