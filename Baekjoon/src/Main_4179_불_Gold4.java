import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 불을 또 하나의 벽으로.
// 결국엔 지훈이가 계속해서 늘어나는 벽에 닿지 않고 미로를 빠져나가는 문제다.

public class Main_4179_불_Gold4 {

	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;

	static Queue<Node> jihun;
	static Queue<Node> fire;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		jihun = new LinkedList<Node>();
		fire = new LinkedList<Node>();

		map = new char[N][M];
		visited = new boolean[N][M];

		char[] chr_arr;
		for (int i = 0; i < N; i++) {
			chr_arr = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = chr_arr[j];

				if (map[i][j] == 'J') {
					jihun.offer(new Node(i, j, 0));
					visited[i][j] = true;
				}

				if (map[i][j] == 'F') {
					fire.offer(new Node(i, j));
				}
			}
		}

		bfs();

		String res = (min == Integer.MAX_VALUE) ? "IMPOSSIBLE" : Integer.toString(min);

		System.out.println(res);

	}

	static void bfs() {
		while (!jihun.isEmpty()) {
			
			// 불을 벽으로 취급하고 먼저 늘려준다.
			// fire.size는 계속해서 변한다.
			// 때문에, len에 담아준다.
			int len = fire.size();

			for (int i = 0; i < len; i++) {
				Node node = fire.poll();

				for (int j = 0; j < 4; j++) {
					int x = node.x + dx[j];
					int y = node.y + dy[j];

					// 바깥을 넘어가지 못한다.
					if (!inner(x, y)) {
						continue;
					}
					// 벽을 만나거나 불을 만나면 continue, 벽은 못태우고, 불이 있는자리도 더 못태운다.
					// 지훈이는 태울 수 있다.
					if (map[x][y] == '#' || map[x][y] == 'F') {
						continue;
					}

					map[x][y] = 'F';
					fire.offer(new Node(x, y));
				}

			}
			
			len = jihun.size();

			for (int i = 0; i < len; i++) {
				Node node = jihun.poll();
				
				// 지나간 자리는 땅으로 만들어준다.
				map[node.x][node.y] = '.';

				for (int j = 0; j < 4; j++) {
					int x = node.x + dx[j];
					int y = node.y + dy[j];
					int c = node.c + 1;

					// 바깥을 넘어가면. 이동거리 체크하고 종료.
					if (!inner(x, y)) {
						if (min > c) {
							min = c;
						}
						continue;
						//return;
					}
					// 벽을 만나거나 불을 만나면.
					if (map[x][y] != '.') {
						continue;
					}

					if (visited[x][y] == false) {
//						System.out.println("this");
						//지훈이의 위치를 찍어준다.
						map[x][y] = 'J';
						visited[x][y] = true;
						jihun.offer(new Node(x, y, c));
					}

				}
			}
			
			
//			printMap();

		}
	}

	static boolean inner(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		} else {
			return false;
		}

	}

	static class Node {
		int x = 0;
		int y = 0;
		int c = 0;

		public Node(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
