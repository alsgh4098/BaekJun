import java.util.Scanner;

public class Main_11726_2xN타일링_silver3 {
	
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i < N+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[N]);
		
	}

}
