import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main_다리만들기2_gold3 {

	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[] colors;
	static boolean[][] connect;
	static ArrayList<Bridge> list;
	static int[] parent;

	static int N;
	static int M;
	static int min;

	static class Bridge {

		// 현재 다리 위치
		int start;
		int finish;
		// 다리의 길이
		int cnt;
		int x;
		int y;

		public Bridge(int start, int finish, int cnt) {
			super();
			this.start = start;
			this.finish = finish;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);

		map = new int[N][M];
		min = Integer.MAX_VALUE;
		list = new ArrayList<Bridge>();

		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		} // end input

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}// print input

		// 섬들에게 색을 입혀준다
		// 색은 2부터 3, 4, 5, 6...
		int color = 2;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					makeColor(i, j, color++);
				}
			}
		}

		// 섬이 3개라면
		// 0 1 2 3 4 5 만큼 만들어지고
		// 2 3 4번을 사용한다.
		colors = new boolean[color];
		// 섬은 2번 부터 시작
		// 2번부터 바다와 만나는 경계를 찾고 dfs를 진행한다.

		colors[2] = true;
		// 2번 섬에서 부터 출발.

		for (int i = 2; i < color; i++) {
			makeBridge(i);
		}

		parent = new int[color];
		for (int i = 0; i < color; i++) {
			parent[i] = i;
		}

		Collections.sort(list, new Comparator<Bridge>() {
			@Override
			public int compare(Bridge o1, Bridge o2) {
				if (o1.cnt > o2.cnt) {
					return 1;
				} else if(o1.cnt < o2.cnt){
					return -1;
				}else {
					return 0;
				}
			}
		});

		int sum = 0;
		int edgeLen = 0;

		for (Bridge brdg : list) {
			int start = brdg.start;
			int finish = brdg.finish;
			int cnt = brdg.cnt;
//			System.out.println(cnt);
			if (union(start, finish)) {
				sum += cnt;
				edgeLen++;
			}
		}
		
//		System.out.println(edgeLen);

		if (edgeLen < color - 3) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
		}

	}

	private static int findRoot(int idx) {

		if (parent[idx] == idx) {
			return idx;
		} else {
			return parent[idx] = findRoot(parent[idx]);
		}

	}

	private static boolean union(int idx1, int idx2) {

		idx1 = findRoot(idx1);
		idx2 = findRoot(idx2);

		if (idx1 != idx2) {
			parent[idx2] = idx1;
			return true;
		} else {
			return false;
		}
	}

	private static void makeBridge(int start) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == start) {
					connect(i, j, start);
				}
			}
		}

	}

	private static void connect(int x, int y, int start) {

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int ncnt = 0;

			while (true) {
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					// 다른 섬을 만난경우
					if (map[nx][ny] != start && map[nx][ny] != 0) {
						// 길이가 2미만인 경우
						if (ncnt < 2) {
							break;
						} else {
							list.add(new Bridge(start, map[nx][ny], ncnt));
							break;
						}
					// 출발지점의 섬에 도착하면 종료
					}else if(map[nx][ny] == start){
						break;
					}
				// 범위 벗어나면 종료
				}else {
					break;
				}

				nx += dx[i];
				ny += dy[i];
				ncnt++;

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

			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				makeColor(nx, ny, color);
			}
		}

	}

}
