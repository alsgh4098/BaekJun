import java.util.Scanner;

public class Main_9663_N_Queen_silver1 {
	
	static int[][] map;
	static int N;
	static int[] queen;
	static boolean[] visited;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][N];
		queen = new int[N];
		visited = new boolean[N];
		
		dfs(0,0);
		
		System.out.println(res);

	}
	
	static void dfs(int x,int count) {
		if(count == N) {

			res++;
			
			return;
		}
		
		if(0>x || x >= N) {
			return;
		}

		
		for (int i = 0; i < N; i++) {
			if( before(i) ) {
				queen[x] = i;
				dfs(x+1,count+1);
			}else {
			}
		}
	}
	
	static boolean before(int c) {
		for (int i = 0; i < c; i++) {
			if(queen[i] == queen[c]) {
				return false;
			}
			
			if( Math.abs(i-c) == Math.abs(queen[i] - queen[c])) {
				return false;
			}
		}
		
		return true;
	}

}
