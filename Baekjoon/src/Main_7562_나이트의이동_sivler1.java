import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동_sivler1 {
	
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	static int tx;
	static int ty;
	
	static int[] dx = {-2,-1,+1,+2,+2,+1,-1,-2};
	static int[] dy = {+1,+2,+2,+1,-1,-2,-2,-1};
	
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			tx = Integer.parseInt(st.nextToken());
			ty = Integer.parseInt(st.nextToken());
			// end input
			
			bfs(sx,sy,0);
			System.out.println(min);
		}

	}// end main
	
	static void bfs(int sx, int sy, int scnt) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {sx,sy,scnt});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			if(temp[0] == tx && temp[1] == ty) {
				if(min > temp[2]) {
					min = temp[2];
				}
			}
			
			for (int i = 0; i < 8; i++) {
				int x = temp[0]+dx[i];
				int y = temp[1]+dy[i];
				int cnt = temp[2]+1;
				
				if(inner(x,y)&&!visited[x][y]) {
					visited[x][y] = true;
					q.offer(new int[] {x,y,cnt});
				}
				
			}
			
		}
		
	}
	
	static boolean inner(int x,int y) {
		if(0<= x && x < N
		  && 0<= y && y< N) {
			return true;
		}else {
			return false;
		}
	}
	
	
	

}
