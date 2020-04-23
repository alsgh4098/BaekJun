import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어_gold5 {
	
	static int N;
	
	static int[][] map;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int sec;
	
	static class Shark{
		int x = 0;
		int y = 0;
		int size = 2;
		int count = 0;
		
		public Shark(int x, int y,int size, int count) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.count = count;
		}
		
		public Shark(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public Shark() {
			super();
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st;
		
		Shark sh = null;
		
		sec = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sh = new Shark(i,j);
				}
			}
		}// end input
		
		bfs(sh);
		
		System.out.println(sec);
		
		
	}
	
	static void bfs(Shark sh) {
		Queue<Shark> q = new LinkedList<Shark>();
		
		q.offer(sh);
		
		while(!q.isEmpty()) {
			// 종료조건 -- 더이상 먹을 물고기가 없을때.
			Shark ths = q.poll();
			
			if(!fishCheck(ths)) {
				sec = ths.count;
				break;
			}
			

			
			for (int i = 0; i < 4; i++) {
				int x = ths.x+dx[i];
				int y = ths.y+dy[i];
				int size = ths.size;
				int count = ths.count;
				if(inner(x,y)) {
					// 사이즈가 작은 물고기가 있을 때. 먹음
					int temp = 0;
					if(size > map[x][y] && map[x][y] != 0) {
						temp = map[x][y];
						map[x][y] = 0;
						size += 1;
					}
					// 사이즈가 같거나 작은 물고기가 있거나 이동할수 있는 공간이 있을 때.
					if(size >= map[x][y]) {
						q.offer(new Shark(x,y,size,count+1));
						map[x][y] = temp;
					}
//					System.out.println(count+1);
//					printMap();
//					System.out.println();
				}
				
			}
			

			
		}
	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static boolean fishCheck(Shark sh) {
		boolean check = false;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 9 && map[i][j] != 0) {
					if(map[i][j] < sh.size) {
						check = true;
					}
				}
			}
		}
		
		return check;
	}
	
	static boolean inner(int x,int y) {
		if( 0<= x && x < N && 0<=y && y<N) {
			return true;
		}else {
			return false;
		}
	}

}
