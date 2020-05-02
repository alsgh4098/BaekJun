import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import oracle.jrockit.jfr.tools.ConCatRepository;

public class Main_알고스팟_gold4 {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if (this.dist > o.dist) {
				return 1;
			} else {
				return -1;
			}
		}

	}

	static int[][] room;
	static int[][] dist;
	static boolean[][] visited;
	static PriorityQueue<Node> qu;
	static String[] line;
	static String line2;

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		line = br.readLine().split(" ");
		int M = Integer.parseInt(line[0]);
		int N = Integer.parseInt(line[1]);

		room = new int[N][M];

		for (int i = 0; i < N; i++) {
			line2 = br.readLine();
			for (int j = 0; j < M; j++) {
				room[i][j] = line2.charAt(j) - '0';
			}
		} // end input

		visited = new boolean[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		qu = new PriorityQueue<Node>();
		qu.add(new Node(0, 0, dist[0][0]));

		// dijkstra + BFS
		while (!qu.isEmpty()) {
			Node ths = qu.poll();
//			System.out.println(ths.x +" "+ths.y);
			if (ths.x == N && ths.y == M ) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = ths.x + dx[i];
				int ny = ths.y + dy[i];
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (dist[nx][ny] > dist[ths.x][ths.y] + room[nx][ny]) {
						dist[nx][ny] = dist[ths.x][ths.y] + room[nx][ny];
//						System.out.println(nx+" "+ny);
						qu.add(new Node(nx, ny, dist[nx][ny]));
					}
				}
			}

		}
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(dist[i][j]+" ");
//			}
//			System.out.println();
//		}

		// 0 1 2 3 4 5 6 7 8 9

		System.out.println(dist[N-1][M-1]);

	}

}
