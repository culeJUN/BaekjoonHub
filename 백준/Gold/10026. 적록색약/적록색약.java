// 10026 골드5 적록색약

import java.io.*;

class Main {
	static int N;
	
	static char[][] map;
	static boolean[][] visited;
	
	static int count = 0;
	static char nowAlpha;
	
	static char[][] mmap;
	static boolean[][] vvisited;
	
	static int ccount = 0;
	static char nnowAlpha;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];		

		mmap = new char[N][N];
		vvisited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				
				if (str.charAt(j) == 'R' || str.charAt(j) == 'G') {
					mmap[i][j] = 'a';
				}
				else {
					mmap[i][j] = str.charAt(j);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					count++;
					nowAlpha = map[i][j];
					bfs(i, j);
				}
				
				if (!vvisited[i][j]) {
					ccount++;
					nnowAlpha = mmap[i][j];
					bbfs(i, j);
				}
			}
		}	
		
		System.out.println(count + " " + ccount);
	}
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == nowAlpha && !visited[nx][ny]) {
					bfs(nx, ny);
				}
			}
		}
	}
	
	static void bbfs(int x, int y) {
		vvisited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (mmap[nx][ny] == nnowAlpha && !vvisited[nx][ny]) {
					bbfs(nx, ny);
				}
			}
		}
	}
}