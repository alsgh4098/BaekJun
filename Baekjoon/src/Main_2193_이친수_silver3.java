import java.util.Scanner;

public class Main_2193_이친수_silver3 {
	
	static Long[] dp;
	
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dp = new Long[N];
		
		dp[0] = 1L;
		if(N>1) {			
			dp[1] = 1L;
		}
		
		for (int i = 2; i < N; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[N-1]);
	}

}
