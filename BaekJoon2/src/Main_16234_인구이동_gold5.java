import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16234_인구이동_gold5 {
	
	static int N,L,R;
	
	static int[][] map;
	static int[][] visited;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int sum;
	static int con;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// end input
		
		int res = 0;
		while(true) {
			boolean stop = true;
			
			int visit = 1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sum = 0;
					// 연결된 갯수.
					con = 0;
					if(visited[i][j] != visit) {
						dfs(i,j,visit);
						
						if(con>1) {
							for (int x = 0; x < N; x++) {
								for (int y = 0; y < N; y++) {
									if(visited[x][y] == visit) {
										map[x][y] = sum/con;
										stop = false;
									}
								}
							}// change
						}
						visit++;
					}
					
				}
			}
			
			visited = new int[N][N];
			
			if(stop) {
				break;
			}else {
				res++;
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}// end logic
		

		
		System.out.println(res);
	}

	private static void dfs(int x, int y, int visit) {
		if(visited[x][y] != 0) {
			return;
		}
		
		sum += map[x][y];
		
		con++;
		visited[x][y] = visit;
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0>nx || nx>=N || 0>ny || ny>=N) {
				continue;
			}
			
			if(Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R) {
				dfs(nx,ny,visit);
			}
		}
		
	}

}
