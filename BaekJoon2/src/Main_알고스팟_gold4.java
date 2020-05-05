import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_알고스팟_gold4 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Node{
		int x;
		int y;
		int dist;
		int block;

		public Node(int x, int y, int dist, int block) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.block = block;
		}

	}

	static int[][] room;
	static boolean[][][] visited;
	static Queue<Node> qu;
	static int min;
	static String[] line;
	static String line2;

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int K = Integer.parseInt(line[2]);

		room = new int[N][M];
		visited = new boolean[N][M][11];

		for (int i = 0; i < N; i++) {
			line2 = br.readLine();
			for (int j = 0; j < M; j++) {
				room[i][j] = line2.charAt(j) - '0';
			}
		} // end input

		min = Integer.MAX_VALUE;
		qu = new LinkedList<Node>();
		
		// 벽을 몇번 부수고 왔는지.
		visited[0][0][0] = true;
		// x y dist k
		qu.add(new Node(0, 0, 1, 0));

		// BFS
		while (!qu.isEmpty()) {
			Node ths = qu.poll();

			if (ths.x == N - 1 && ths.y == M - 1) {
				min = Math.min(ths.dist, min);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = ths.x + dx[i];
				int ny = ths.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					
					if (room[nx][ny] == 1) {
						if (ths.block < K && visited[nx][ny][ths.block + 1] == false) {
							visited[nx][ny][ths.block+1] = true;
							qu.add(new Node(nx, ny, ths.dist + 1, ths.block + 1));
						}
					} else {
						if (visited[nx][ny][ths.block] == false) {
							visited[nx][ny][ths.block] = true;
							qu.add(new Node(nx, ny, ths.dist + 1, ths.block));
						}

					}

				}
			}

		}

		// 0 1 2 3 4 5 6 7 8 9

		System.out.println( min == Integer.MAX_VALUE ? -1 : min);

	}

}
