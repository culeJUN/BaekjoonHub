// 1260 실버2 DFS와 BFS

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int V;

    static boolean[][] map;
    static boolean[] check;

    static StringBuilder sb;
    static Queue<Integer> bfsQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            map[i][j] = true;
            map[j][i] = true;
        }

        sb = new StringBuilder();
        DFS(V);
        sb.append("\n");
        check = new boolean[N + 1];
        BFS(V);
        System.out.println(sb);
    }

    static void DFS(int start) {
        // 1. 체크인
        check[start] = true;
        // 2. 목적지?
        sb.append(start + " ");
        // 3. 연결된 곳 순회
        for (int i = 0; i <= N; i++) {
            // 4. 갈 수 있나?
            if (map[start][i] && !check[i]) {
                // 5. 간다
                DFS(i);
            }
        }
        // 6. 체크 아웃 생략
    }

    static void BFS(int start) {
        bfsQ.add(start);
        check[start] = true;

        while (!bfsQ.isEmpty()) {
            // 1. 큐에서 빼기
            start = bfsQ.poll();
            // 2. 목적지?
            sb.append(start + " ");
            // 3. 연결된 곳 순회
            for (int i = 0; i <= N; i++) {
                // 4. 갈 수 있나?
                if (map[start][i] && !check[i]) {
                    // 5. 체크인
                    check[i] = true;
                    // 6. 큐에 넣음
                    bfsQ.add(i);
                }
            }
        }
    }
}
