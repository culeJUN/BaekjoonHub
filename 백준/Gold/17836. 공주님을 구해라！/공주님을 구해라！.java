// 17836 골드5 공주님을 구해라!

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int T;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Queue<Node> bfsQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N + 1][M + 1][2];
        int result = BFS(1, 1);

        if (result == -1) {
            System.out.println("Fail");
        }
        else {
            System.out.println(result);
        }

    }

    public static int BFS(int x, int y) {
        Queue<Node> bfsQ = new LinkedList<>();
        bfsQ.add(new Node(x, y, 0, false));
        visited[x][y][0] = true;

        while (!bfsQ.isEmpty()) {
            Node now = bfsQ.poll();

            if (now.count > T) {            // 횟수 초과
                break;
            }
            if (now.x == N && now.y == M) {         // 도착
                return now.count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 1 && ny >= 1 && nx <=N && ny <= M) {
                    if (!now.isGram) {
                        if (!visited[nx][ny][0] && map[nx][ny] == 0) {
                            bfsQ.add(new Node(nx, ny, now.count + 1, now.isGram));
                            visited[nx][ny][0] = true;
                        }
                        else if (!visited[nx][ny][0] && map[nx][ny] == 2) {
                            bfsQ.add(new Node(nx, ny, now.count + 1, true));
                            visited[nx][ny][1] = true;
                        }
                    }
                    else {
                        if (!visited[nx][ny][1]) {
                            bfsQ.add(new Node(nx, ny, now.count + 1, now.isGram));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }

        return  -1;
    }
}



class Node {
    int x;
    int y;
    int count;
    boolean isGram;

    public Node(int x, int y, int count, boolean isGram) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isGram = isGram;
    }
}