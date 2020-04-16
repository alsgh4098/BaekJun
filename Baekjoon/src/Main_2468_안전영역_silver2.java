import java.util.Scanner;

public class Main_2468_안전영역_silver2 {

	static int N;

	static int[][] map;
	static boolean[][] visited;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int count = 0;

		// 높이를 0부터 9까지 체크하고 제일 바깥 for문이 돌때마다 해당 높이의 지점을 0으로 침수시킨다.
		for (int k = 0; k < 100; k++) {
			// count 0으로 초기화.
			count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == k) {
						map[i][j] = -1;
					}
				}
			}

//			printMap();

			// solution
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != -1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}

			if (max < count) {
				max = count;
			}

			visited = new boolean[N][N];
		}

		System.out.println(max);

	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			if (inner(x + dx[i], y + dy[i])
				&& !visited[x + dx[i]][y + dy[i]]
				&& map[x + dx[i]][y + dy[i]] != -1 ) {
				dfs(x + dx[i], y + dy[i]);
			}
		}

	}


	static boolean inner(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		} else {
			return false;
		}
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
