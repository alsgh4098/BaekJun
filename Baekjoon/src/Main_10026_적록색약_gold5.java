import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_적록색약_gold5 {
	
	static int N;
	
	static char[][] color;
	static char[][] color_blind;
	
	static boolean[][] visited;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int color_res = 0;
	static int color_blind_res = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		color = new char[N][N];
		color_blind = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			
			char[] chr_arr = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				color[i][j] = chr_arr[j];
				if(color[i][j] == 'R') {
					color_blind[i][j] = 'G';
				}else {
					color_blind[i][j] = color[i][j];
				}
			}
		}
		
		solution();
		
		System.out.println(color_res + " " + color_blind_res);
	}
	
	static void solution() {
		char[] arr = {'B','G','R'};
		
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(color[i][j] == arr[k]
					   && !visited[i][j]) {						
						dfs(i,j,arr[k],color);
						color_res++;
					}
				}
			}
			visited = new boolean[N][N];
		}
		
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(color_blind[i][j] == arr[k]
					    && !visited[i][j]) {						
						dfs(i,j,arr[k],color_blind);
						color_blind_res++;
					}
				}
			}
			visited = new boolean[N][N];
		}

	}
	
	static void dfs(int x, int y,char color,char[][] map) {
		if(!inner(x,y)) {
			return;
		}
		if(map[x][y] != color) {
			return;
		}
		if(visited[x][y]) {
			return;
		}
		
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			dfs(nx,ny,color,map);
		}
	}
	
	static boolean inner(int x, int y) {
		if( 0<= x && x< N
		   && 0<= y && y< N) {
			return true;
		}else {
			return false;
		}
	}
}
