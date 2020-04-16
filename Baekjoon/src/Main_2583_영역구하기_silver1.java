import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기_silver1 {
	static int M;
	static int N;
	static int K;
	static int[][] map;
	static ArrayList<Integer> list;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static Queue<int[]> q;
	static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M + 2][N + 2];
		list = new ArrayList<>();

		for (int i = 0; i < M + 2; i++) {
			map[i][0] = 3;
			map[i][N + 1] = 3;
		}

		for (int i = 0; i < N + 2; i++) {
			map[0][i] = 3;
			map[M + 1][i] = 3;
		}

		int sx = 0;
		int sy = 0;
		int ex = 0;
		int ey = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken()) + 1;
			sy = Integer.parseInt(st.nextToken()) + 1;
			ex = Integer.parseInt(st.nextToken()) + 1;
			ey = Integer.parseInt(st.nextToken()) + 1;
			for (int j = sy; j < ey; j++) {
				for (int j2 = sx; j2 < ex; j2++) {
					map[j][j2] = 1;
				}
			}
		}

		
		
		q = new LinkedList<int[]>();

		for (int i = 1; i < M + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] == 0) {
					solution(i, j);
				}
			}
		}
//		printMap(map);

		System.out.println(list.size());
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d ", list.get(i));
		}

	}

	static void solution(int sx, int sy) {

		c = 0;

		q.offer(new int[] { sx, sy});

		while (!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			if (map[x][y] == 0) {
				c++;
				map[x][y] = 2;
				for (int i = 0; i < 4; i++) {
					int cx = x + dx[i];
					int cy = y + dy[i];
					if (map[cx][cy] == 0) {
						q.offer(new int[] { cx, cy });
					}
				}
			}
		}

		list.add(c);

	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < M + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
