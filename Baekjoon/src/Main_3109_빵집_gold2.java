import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//런타임에러
//컴파일에러

public class Main_3109_빵집_gold2 {

	static char[][] map;
	static int[][] visited;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N + 2][M + 2];
		visited = new int[N + 2][M + 2];
		
		// 패딩
		for (int i = 0; i < N + 2; i++) {
			map[i][0] = '0';
			map[i][M + 1] = '0';
			visited[i][0] = 2;
			visited[i][M + 1] = 2;
		}

		for (int i = 0; i < M + 2; i++) {
			map[0][i] = '0';
			map[N + 1][i] = '0';
			visited[0][i] = 2;
			visited[N + 1][i] = 2;
		}

		
		// 입력
		char[] chr_arr;

		for (int i = 1; i < N + 1; i++) {
			chr_arr = br.readLine().toCharArray();
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = chr_arr[j - 1];
				if(map[i][j] == 'x') {
					visited[i][j] = 2;
				}
			}
		}
		
		
		//dfs
		for (int i = 1; i < N + 1; i++) {
			if (map[i][1] == '.') {
				solution(i, 1);
			}
		}

		int count = 0;

		for (int i = 1; i < N + 1; i++) {
			if (visited[i][M] == 1) {
				count++;
			}
		}
//		printMap();
		System.out.println(count);
	}

	static boolean solution(int x, int y) {

		visited[x][y] = 1;

		if (y == M ) {
			return true;
		}

		if (map[x][y] != '.') {
			return false;
		}
		
		// break로 멈추면 한 방향탐색만 하고 멈추게 됨.
		for (int i = 0; i < 3; i++) {
			if (visited[x + dx[i]][y + dy[i]] == 0 && map[x + dx[i]][y + dy[i]] == '.') {
				if(solution(x + dx[i], y + dy[i])) {
					return true;
				}
				
			}
		}
		
		return false;
	}


	static void printMap() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
	}

}