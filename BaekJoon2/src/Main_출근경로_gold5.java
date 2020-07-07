import java.util.Scanner;

public class Main_출근경로_gold5 {
	
	static int[][][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		int mod = 100000;
		
		dp = new int[w][h][2][2];
		
		dp[1][0][0][0] = 1;
		dp[1][0][0][1] = 1;
		dp[1][0][1][0] = 1;
		dp[1][0][1][1] = 1;
		
		dp[0][1][0][0] = 1;
		dp[0][1][0][1] = 1;
		dp[0][1][1][0] = 1;
		dp[0][1][1][1] = 1;
		
		for (int i = 1; i < w; i++) {
			for (int j = 1; j < h; j++) {
				dp[i][j][0][0] = (dp[i][j-1][0][0] + dp[i-1][j][1][1])%mod;
				dp[i][j][0][1] = dp[i][j-1][0][0]%mod;
				dp[i][j][1][0] = (dp[i][j-1][0][1] + dp[i-1][j][1][0])%mod;
				dp[i][j][1][1] = dp[i-1][j][1][0]%mod;
			}
		}
		
		long res = ( dp[w-1][h-1][0][0] + dp[w-1][h-1][0][1] + dp[w-1][h-1][1][0] + dp[w-1][h-1][1][1] ) %mod;
		
		System.out.println(res);
	}

}
