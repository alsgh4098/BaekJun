import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_알고스팟_메모리초과_인접행렬_gold4 {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Node implements Comparable<Node>{
		int idx;
		int dist;
		
		public Node(int idx, int dist) {
			super();
			this.idx = idx;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if(this.dist > o.dist) {
				return 1;
			}else {
				return -1;
			}
		}
		
		
	}
	static int[][] room;
	static int[][] graph;
	static int[][] idx;
	static int[] dist;
	static boolean[] visited;
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
		graph = new int[N*M][N*M];
		idx = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			line2 = br.readLine();
			for (int j = 0; j < M; j++) {
				room[i][j] = line2.charAt(j)-'0';
			}
		}// end input
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				idx[i][j] = cnt++;
			}
		}// make idx
		
		// 연결이 없는곳 -1
		for (int i = 0; i < N*M; i++) {
			Arrays.fill(graph[i], -1);
		}
		int ths;
		int nx;
		int ny;
		int tht;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ths = idx[i][j];
				for (int k = 0; k < 4; k++) {
					nx = i+dx[k];
					ny = j+dy[k];
					
					if(0<=nx && nx<N && 0<=ny && ny<M) {
						tht = idx[nx][ny];
						
						graph[ths][tht] = room[nx][ny];
						graph[tht][ths] = room[i][j];
					}
				}
			}
		}// make graph
		
//		for (int i = 0; i < N*M; i++) {
//			for (int j = 0; j < M*M; j++) {
//				System.out.print(graph[i][j]+" ");
//			}
//			System.out.println();
//		}// graph test
		
		dist = new int[N*M];
		visited = new boolean[N*M];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		int start = 0;
		int finish = (N*M)-1;
		
		qu = new PriorityQueue<Node>();
		qu.add(new Node(start,dist[0]));
		// dijkstra
		while(!qu.isEmpty()) {
			Node thsn = qu.poll();
			
			visited[thsn.idx] = true;
			
			for (int i = 0; i < N*M; i++) {
				if(i != thsn.idx) {
					if(graph[thsn.idx][i] != -1 && visited[i] == false) {
						
						if(dist[i] > dist[thsn.idx] + graph[thsn.idx][i]) {
							dist[i] = dist[thsn.idx] + graph[thsn.idx][i];
							qu.add(new Node(i,dist[i]));
						}
					}
				}
			}
			
		}
		
		// 0 1 2 3 4 5 6 7 8 9
		
		
		System.out.println(dist[finish]);
		
	}

}
