import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_미세먼지안녕2_gold5 {
	
	static int R,C,T;
	static int[][] map;
	static int[][] airclnr;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		T = Integer.parseInt(line[2]);
		
		map = new int[R][C];
		// 총 두개의 공기 청정기
		// [0][0] 첫번째 공기청정기 x
		// [0][1] 첫번째 공기청정기 y		
		airclnr = new int[2][2];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				
				if(map[i][j] == -1) {
					airclnr[idx][0] = i;
					airclnr[idx++][1] = i;					
				}
			}
		}// end input
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}// print input
		
		// T초 동안 진행
		while(T!=0) {
			int[][] nmap = new int[R][C];
			// 확산.
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					// 확산 횟수
					int cnt = 0;
					// 미세먼지가 좌표에 있는 경우.
					if(map[i][j] != 0 && map[i][j] != -1) {
						// 네방향으로 확산.
						for (int k = 0; k < 4; k++) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							if(0<=nx && nx<R && 0<=ny && ny<C) {
								
								if(map[nx][ny] != -1) {
									cnt++;
									nmap[nx][ny] += map[i][j]/5;
								}
							}
						}
						nmap[i][j] += map[i][j] - ((map[i][j]/5)*cnt);
					}else if(map[i][j] == -1) {
						nmap[i][j] = -1;
					}
				}
			}
//			printMap(nmap);
			// 공기청정기 작동.
			// 위쪽 공기 청정기
			
			// 위쪽 공기청정기
			int r1x = airclnr[0][0];
//			int r1y = airclnr[0][1];
			
			// 아래쪽
			for (int i = r1x-1; i > 0; i--) {
				nmap[i][0] = nmap[i-1][0];
			}
			// 왼쪽
			for (int i = 0; i < C-1; i++) {
				nmap[0][i] = nmap[0][i+1];
			}
			
			// 위쪽
			for (int i = 0; i < r1x; i++) {
				nmap[i][C-1] = nmap[i+1][C-1];
			}
			
			// 오른쪽
			// 공기청정기 한칸 옆부터
			for (int i = C-1; i > 1; i--) {
				nmap[r1x][i] = nmap[r1x][i-1];
			}
			nmap[r1x][1] = 0;
			
			// 아래쪽 공기청정기
			int r2x = airclnr[1][0];
//			int r2y = airclnr[1][1];
			
			// 위쪽
			for (int i = r2x+1; i < R-1; i++) {
				nmap[i][0] = nmap[i+1][0];
			}
			// 왼쪽
			for (int i = 0; i < C-1; i++) {
				nmap[R-1][i] = nmap[R-1][i+1];
			}
			
			// 아래쪽
			for (int i = R-1; i > r2x; i--) {
				nmap[i][C-1] = nmap[i-1][C-1];
			}
			
			// 오른쪽
			// 공기청정기 한칸 옆부터
			for (int i = C-1; i > 1; i--) {
				nmap[r2x][i] = nmap[r2x][i-1];
			}
			nmap[r2x][1] = 0;
			
//			nmap[r1x][r1y] = -1;
//			nmap[r2x][r2y] = -1;
			copyMap(nmap);
			
			T--;
		}
		
//		printMap(map);
		
		int res = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1) {					
					res += map[i][j];
				}
			}
		}// end sum
		
		System.out.println(res);
	}// end main
	
	static void copyMap(int[][] nmap) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = nmap[i][j];
			}
		}
	}
	
	static void printMap(int[][] nmap) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(nmap[i][j]+" ");
			}
			System.out.println();
		}
	}

}
