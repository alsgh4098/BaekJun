//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main_인구이동2 {
//	
//	static int N,L,R;
//	
//	static int[][] map;
//	static int[][] visited;
//	
//	static int[] dx = {-1,0,1,0};
//	static int[] dy = {0,1,0,-1};
//	
//	static int max;
//	static int con;
//	static int res;
//	
//	static boolean stop;
//	
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		N = Integer.parseInt(st.nextToken());
//		L = Integer.parseInt(st.nextToken());
//		R = Integer.parseInt(st.nextToken());
//		
//		map = new int[N][N];
//		visited = new int[N][N];
//		
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < N; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}// end input
//		
//		int res = 0;
//		
//		while(true) {
//			
//			boolean check = false;
//			
//			int visit = 1;
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if(visited[i][j] != visit) {
//						dfs(i,j,visit);
//						
//						visit++;
//					}
//				}
//			}
//			
//			
//			if(check) {
//				break;
//			}
//			
//		}// end logic
//		
//
//		
//		System.out.println(res);
//	}
//
//	private static void dfs(int x, int y, int visit) {
//		
//		if(visited[x][y]) {
//			return;
//		}
//		
//		
//	}
//
//}
