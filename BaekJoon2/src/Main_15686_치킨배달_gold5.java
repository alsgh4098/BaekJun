import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_15686_치킨배달_gold5 {

	static int[][] map;
	static boolean[][] visited;
	static int[][] dist;
	static boolean[] find;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static class pair {
		int x;
		int y;

		public pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static List<pair> plist;
	static List<pair> clist;
	static boolean[] carr;
	static boolean[] parr;

	static int res;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		int N = Integer.parseInt(line[0]);

		M = Integer.parseInt(line[1]);

		map = new int[N][N];

		plist = new ArrayList<pair>();
		clist = new ArrayList<pair>();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String line2 = br.readLine().replace(" ", "");
			for (int j = 0; j < N; j++) {
				map[i][j] = line2.charAt(j) - '0';
				if (map[i][j] == 1) {
					plist.add(new pair(i, j));
				} else if (map[i][j] == 2) {
					clist.add(new pair(i, j));
				}
			}
		} // end input

		carr = new boolean[clist.size()];

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}// print

		res = Integer.MAX_VALUE;

		dfs(0, 0);

		System.out.println(res);

	}// end main

	private static void dfs(int start, int cnt) {
		if (cnt == M) {
			res = Math.min(res, calc());
		}

		for (int i = start; i < carr.length; i++) {
			carr[i] = true;
			dfs(i + 1, cnt + 1);
			carr[i] = false;
		}

	}

	private static int calc() {
		int res = 0;

		for (int j = 0; j < plist.size(); j++) {

			int min = Integer.MAX_VALUE;
			for (int i = 0; i < clist.size(); i++) {
				if (carr[i]) {
					int val = Math.abs(clist.get(i).x - plist.get(j).x) + Math.abs(clist.get(i).y - plist.get(j).y);
					if (min > val) {
						min = val;
					}

				}
			}
			res += min;

		}
//		System.out.println(res);
		return res;
	}
}
