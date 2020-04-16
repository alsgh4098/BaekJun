import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색_silver1 {
	
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		String number = "";
		for (int i = 0; i < N; i++) {
			number = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = number.charAt(j)-'0';
			}
		}
		
		bfs();
		
//		printMap();
		
		System.out.println(min);
		
	}
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {0,0,1});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			int dist = temp[2];
			
			visited[x][y] = dist;
			
			if(x == N-1 && y== M-1) {
				if(min > dist) {
					min = dist;
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if(inner(x+dx[i],y+dy[i])
				   && map[x+dx[i]][y+dy[i]] == 1) {
					if(dist+1 < visited[x+dx[i]][y+dy[i]]) {
						visited[x+dx[i]][y+dy[i]] = dist+1;
						q.offer(new int[] {x+dx[i],y+dy[i],dist+1});
					}
				}
			}
		}
	}
	
	static boolean inner(int x,int y) {
		if(0<= x && x < N
		  && 0<= y && y < M) {
			return true;
		}else {
			return false;
		}
	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
	}
	

}
