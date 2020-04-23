import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형_silver1 {
	
	static int N;
	
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][];
		dp = new int[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = new int[i+1];
			dp[i] = new int[i+1];
		}
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		
		// 대각선
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i-1][0] + map[i][0];
			dp[i][i] = dp[i-1][i-1] + map[i][i];
		}
		
		// 가운데
		for (int i = 2; i < N; i++) {
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max( dp[i-1][j-1] + map[i][j] , dp[i-1][j] + map[i][j] );
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			if( dp[N-1][i] > max ) {
				max = dp[N-1][i];
			}
		}
		
		System.out.println(max);

	}

}
