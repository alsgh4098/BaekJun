import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_RGB거리_silver1 {
	
	static int map[][];
	
	static int dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][3];
		
		dp = new int[N][3];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		
		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1] + map[i][0] , dp[i-1][2] + map[i][0] );
			dp[i][1] = Math.min(dp[i-1][0] + map[i][1] , dp[i-1][2] + map[i][1] );
			dp[i][2] = Math.min(dp[i-1][1] + map[i][2] , dp[i-1][0] + map[i][2] );
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			if(dp[N-1][i] < min) {
				min = dp[N-1][i];
			}
		}
		
		System.out.println(min);
		
		// 행 : 집
		
		// 열 : R G B
		
		
		// 이전 집이랑 계속 색깔이 다르게.
		// 이전 집 인덱스

	}

}

