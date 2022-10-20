// 2615 실버1 오목

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[21][21];
    static int[][][] memo = new int[21][21][4];
    static int[][] d = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}}; // 윗대각, 오른쪽, 아래대각, 아래

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 19; i++) {
             st = new StringTokenizer(br.readLine());

             for (int j = 1; j <= 19; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
             }
        }

        System.out.println(fiveOmok());
    }

    static String fiveOmok() {
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {     // 위에서 아래로 for문
                if (map[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (memo[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) {      // 처음으로 시작점으로 선택 && 거기서 부터 5개
                            return map[i][j] + "\n" + i + " " + j + "\n";
                        }
                    }
                }
            }
        }
        return "0";
    }

    static int calc(int x, int y, int dir, int color) {     // dir = 방향 / color = 바둑돌 색
        int nx = x + d[dir][0];
        int ny = y + d[dir][1];

        if (map[nx][ny] == color) {
            return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1;
        }

        return 1;
    }
}