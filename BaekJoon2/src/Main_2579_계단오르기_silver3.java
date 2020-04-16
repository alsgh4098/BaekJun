import java.util.Scanner;

public class Main_2579_계단오르기_silver3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		int[] stair = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			stair[i] = sc.nextInt();
		}
		
		dp[0] = 0;
		dp[1] = stair[1];
		if(N>=2) {			
			dp[2] = stair[2] + stair[1];
		}
		
		if(N>=3) {			
			dp[3] = Math.max(stair[1]+stair[3], stair[2]+stair[3]);
		}
		
		for (int i = 4; i < stair.length; i++) {
			dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
		}
		
		
		System.out.println(dp[N]);
	}

}
