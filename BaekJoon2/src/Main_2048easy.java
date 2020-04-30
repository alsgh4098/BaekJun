import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2048easy {
	
	static int[][] map;
	static int N;
	static int[] ways;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		ways = new int[5];
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}// end input
		
//		test input
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		max = Integer.MIN_VALUE;
		
		dfs(0);
		
		System.out.println(max);
	}
	
	private static void dfs(int cnt) {
		if(cnt == 5) {
			max = Math.max(max, solve(ways));
			return;
		}
		
		ways[cnt] = 1;
		dfs(cnt+1);
		ways[cnt] = 2;
		dfs(cnt+1);
		ways[cnt] = 3;
		dfs(cnt+1);
		ways[cnt] = 4;
		dfs(cnt+1);
		
	}

	static int solve(int[] ways) {
		int[][] nmap = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				nmap[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < ways.length; i++) {
			int way = ways[i];
			nmap = move(nmap,way);
		}
//		System.out.println("------------------------------");
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(nmap[i][j] > max) {
					max = nmap[i][j];
				}
			}
		}
		
		return max;
	}

	private static int[][] move(int[][] nmap, int way) {
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = nmap[i][j];
			}
		}
		
		boolean[][] visited = null;
		
		int cx = 0;
		int cy = 0;
		int vx = 0;
		int vy = 0;
		
		// 상
		if(way == 1) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cx = j;
					cy = i;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = j+1;
						vy = i;
						boolean find = false;
						while(vx < N) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vx++;
						}
						if(find) {					
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cx-1>=0) {
								if(map[cx-1][cy] == map[cx][cy] && visited[cx-1][cy] == false) {
									map[cx-1][cy]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx-1][cy] = true;
									j--;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cx+1<N) {
							if(map[cx][cy] == map[cx+1][cy] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx+1][cy];
								map[cx+1][cy] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		// 하
		}else if(way == 2) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >=0; j--) {
					cx = j;
					cy = i;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = j-1;
						vy = i;
						boolean find = false;
						while(vx >= 0) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vx--;
						}
						if(find) {							
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cx+1<N) {
								if(map[cx+1][cy] == map[cx][cy] && visited[cx+1][cy] == false) {
									map[cx+1][cy]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx+1][cy] = true;
									j++;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cx-1>=0) {
							if(map[cx][cy] == map[cx-1][cy] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx-1][cy];
								map[cx-1][cy] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		// 좌	
		}else if(way == 3) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cx = i;
					cy = j;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = i;
						vy = j+1;
						boolean find = false;
						while(vy < N) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vy++;
						}
						if(find) {							
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cy-1>=0) {
								if(map[cx][cy-1] == map[cx][cy] && visited[cx][cy-1] == false) {
									map[cx][cy-1]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx][cy-1] = true;
									j--;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cy+1<N) {
							if(map[cx][cy] == map[cx][cy+1] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx][cy+1];
								map[cx][cy+1] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		// 우
		}else if(way == 4) {
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = N-1; j >=0; j--) {
					cx = i;
					cy = j;
					
					//0이면 뒤에 숫자들을 0으로 댕김
					if(map[cx][cy] == 0) {
						vx = i;
						vy = j-1;
						boolean find = false;
						while(vy >= 0) {
							if(map[vx][vy] != 0) {								
								find = true;
								break;
							}
							vy--;
						}
						if(find) {							
							map[cx][cy] = map[vx][vy];
							map[vx][vy] = 0;
							
							if(cy+1<N) {
								if(map[cx][cy+1] == map[cx][cy] && visited[cx][cy+1] == false) {
									map[cx][cy+1]+=map[cx][cy];
									map[cx][cy] = 0;
									visited[cx][cy+1] = true;
									j++;
								}
							}
						}
					//0이 아니면 뒤에 숫자를 비교해서 합침
					}else {
						if(cy-1>=0) {
							if(map[cx][cy] == map[cx][cy-1] && visited[cx][cy] == false) {
								map[cx][cy]+=map[cx][cy-1];
								map[cx][cy-1] = 0;
								visited[cx][cy] = true;
							}
						}
					}
				}
			}
		}
		
		return map;
	}
}
