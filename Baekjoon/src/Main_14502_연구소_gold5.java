import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14502_연구소_gold5 {
	
	static int[][] map;
	static int[][] mapCopy;
	
	static boolean[][] visited;
	
	static int N;
	static int M;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	static int max = Integer.MIN_VALUE;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		mapCopy = new int[N][M];
		visited = new boolean[N][M];

		count = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mapCopy[i][j] = map[i][j];
			}
		}

		makeWalls(0, 0, 0);

		System.out.println(max);

	}// end main

	static void makeWalls(int sx, int sy, int count) {
		if (count == 3) {
			
			copyMap();
			findSafezone();
			
			int res = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (mapCopy[i][j] == 0) {
						res++;
					}
				}
			}

			if (res > max) {
				max = res;
			}
			initSafe();
			return;
		}

		if(sx >= N) {
			sx = 0;
			sy = sy+1;
		}
		
		if (sy >= M) {
			return;
		}
		

		if (map[sx][sy] == 0) {
			map[sx][sy] = 1;
			makeWalls(sx+1, sy, count + 1);

			map[sx][sy] = 0;
			makeWalls(sx+1, sy, count);
		} else {
			makeWalls(sx+1, sy, count);
		}
		
	}

	static void findSafezone() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapCopy[i][j] == 2 && !visited[i][j]) {
					dfs(i, j);
				}
			}
		}
	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (inner(nx, ny) && !visited[nx][ny] && mapCopy[nx][ny] != 1) {
				visited[nx][ny] = true;
				mapCopy[nx][ny] = 2;
				dfs(nx, ny);
			}
		}
	}
	
	static void copyMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mapCopy[i][j] = map[i][j];
			}
		}
	}
	
	static boolean inner(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		} else {
			return false;
		}
	}


	static void initSafe() {
		visited = new boolean[N][M];
	}
}
