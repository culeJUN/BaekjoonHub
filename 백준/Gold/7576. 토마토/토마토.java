// 7576 골드5 토마토

import java.io.*;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[N][M];
        int cnt = 0, days = 0;
        Queue<int[]> que = new LinkedList<>();

        // 밭 데이터 입력 -> 시작점 큐에 넣기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                tomato[n][m] = Integer.parseInt(st.nextToken());
                if (tomato[n][m] == 1) {
                    que.add(new int[] {n, m});
                }
                else if (tomato[n][m] == 0) {
                    cnt++;
                }
            }
        }

        while (cnt > 0 && !que.isEmpty()) {
            // 하루마다 -> 하루 = 현재 큐 사이즈
            for (int s = que.size(); s > 0; s--) {
                int[] current = que.poll();

                for (int i = 0; i < 4; i++) {
                    int ny = current[0] + dy[i];
                    int nx = current[1] + dx[i];

                    // 범위 밖 or 토마토가 -1 또는 1 = pass
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || tomato[ny][nx] != 0) {
                        continue;
                    }

                    // 범위 안 and 토마토가 0 = 토마토 개수 -1 토마토 1 큐에 넣기
                    cnt--;
                    tomato[ny][nx] = 1;
                    que.add(new int[] {ny, nx});
                }
            }
            days++;
        }
        if (cnt == 0) {
            System.out.println(days);
        }
        else {
            System.out.println(-1);
        }
    }
}
