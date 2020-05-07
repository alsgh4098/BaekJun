import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_다리만들기_gold3 {

	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int N;
	static int min;
	
	static class Bridge{
		
		// 현재 다리 위치
		int x;
		int y;
		// 다리의 길이
		int cnt;
		
		public Bridge(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		min = Integer.MAX_VALUE;
		String[] line;
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		} // end input

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}// print input
		
		// 섬들에게 색을 입혀준다
		// 색은 2부터 3, 4, 5, 6...
		int color = 2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					makeColor(i, j, color++);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (0 <= nx && nx < N && 0 <= ny && ny < N) {
							// 섬에서 바다만나는 지점에서 출발시킨다.
							if(map[nx][ny] == 0) {								
								move(nx, ny, map[i][j]);
							}
						}
					}
				}
			}
		}// end logic
		

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}// print input
		
		System.out.println(min);
		

	}

	private static void move(int x, int y, int color) {
		Queue<Bridge> qu = new LinkedList<Bridge>();
		
		qu.add(new Bridge(x, y, 0));
		
		visited = new boolean[N][N];
		visited[x][y] = true;
		
		while(!qu.isEmpty()) {
			Bridge ths = qu.poll();
			
			if(map[ths.x][ths.y] != 0 && map[ths.x][ths.y] != color) {
				if(min>ths.cnt) {
					min = ths.cnt;
				}
				return;
			}
			
			for (int k = 0; k < 4; k++) {
				int nx = ths.x + dx[k];
				int ny = ths.y + dy[k];

				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(map[nx][ny] != color && visited[nx][ny] != true) {
						visited[nx][ny] = true;
						qu.add(new Bridge(nx, ny, ths.cnt+1));
					}
				}
			}
		}
		
	}

	private static void makeColor(int x, int y, int color) {
		if (map[x][y] != 1) {
			return;
		}

		map[x][y] = color;

		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];

			if (0 <= nx && nx < N && 0 <= ny && ny < N) {
				makeColor(nx, ny, color);
			}
		}

	}

}
