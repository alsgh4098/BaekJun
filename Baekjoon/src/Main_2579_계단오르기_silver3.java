import java.util.Scanner;

public class Main_2579_계단오르기_silver3 {
	
	static int[] dp;
	static int[] res;
	
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dp = new int[N];
		res = new int[N];
		
		for (int i = 0; i < N; i++) {
			dp[i] = sc.nextInt();
			res[i] = dp[i];
		}
		
		res[0] = dp[0];
		res[1] = res[0] + dp[1];
		res[2] = Math.max(dp[2] + dp[0], dp[2] + dp[1]);
		
		
		for (int i = 3; i < N; i++) {
			res[i]  = Math.max(res[i-3] + dp[i-1] + dp[i], res[i-2] + dp[i]);
		}
		
		System.out.println(res[N-1]);

	}

}
