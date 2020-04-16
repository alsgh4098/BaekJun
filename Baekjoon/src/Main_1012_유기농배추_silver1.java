import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_silver1 {
	
	static int N;
	static int M;
	static int K;
	
	static int[][] MAP;
	static boolean[][] VISITED;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			MAP = new int[N][M];
			VISITED = new boolean[N][M];
			
			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				MAP[x][y] = 1;
			}
			
			
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					if(MAP[j][j2] == 1
					   && !VISITED[j][j2]) {
						dfs(j,j2);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		

	}
	
	static boolean inner(int x, int y) {
		if(0<= x && x < N
		  && 0<= y && y < M) {
			return true;
		}else {
			return false;
		}
	}
	
	static void dfs(int x, int y) {
		if(!inner(x,y) || VISITED[x][y] || MAP[x][y] == 0) {
			return;
		}
		
		VISITED[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			dfs(x+dx[i],y+dy[i]);
		}
		
	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(MAP[i][j]);
			}
			System.out.println();
		}
	}

}
