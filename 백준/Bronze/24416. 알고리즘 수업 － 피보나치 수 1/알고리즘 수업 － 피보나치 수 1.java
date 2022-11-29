// 24416 브론즈1 알고리즘 수업 - 피보나치 수 1

import java.io.*;
import java.util.*;

public class Main {
    static int[] dp = new int[41];
    static int regCnt = 1;
    static int dpCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int fib = fib(N);
        int fibonnacci = fibonacci(N);

        dp[1] = 1;
        dp[2] = 1;

        System.out.println(regCnt + " " + dpCnt);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            regCnt++;
            return fib(n - 1) + fib(n - 2);
        }
    }

    static int fibonacci(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
            dpCnt++;
        }
        return dp[n];
    }
}