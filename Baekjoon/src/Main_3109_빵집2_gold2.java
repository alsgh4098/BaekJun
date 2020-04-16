import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//런타임에러
//컴파일에러

public class Main_3109_빵집2_gold2 {

	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int R;
	static int C;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}// end input
		
		// 왼쪽 끝에서 출발
		for (int i = 0; i < R; i++) {
			if(visited[i][0] == false) {				
				visited[i][0] = true;
				if(dfs(i,0)) {
					continue;
				}else {
					visited[i][0] = false;
				}
//				System.out.println();
			}
		}
		
		System.out.println(res);
		
	}

	private static boolean dfs(int r, int c) {
		if(c == C-1) {
			res++;
//			System.out.println("res"+r+","+c);
			return true;
		}
//		System.out.print(r+","+c+" //");
		for (int i = 0; i < 3; i++) {
			int nr = r+dx[i];
			int nc = c+dy[i];
			if( 0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc] == '.') {
				if(visited[nr][nc] == false) {
					visited[nr][nc] = true;
					if(dfs(nr,nc)) {
						return true;
					}
				}
			}
			
		}
		
		return false;
	}

}