import java.util.Scanner;

public class Main_1912_연속합_2_silver2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			dp[i] = sc.nextInt();
		}
		
		for (int i = 1; i < N; i++) {
			if(dp[i-1] < 0) {
			}else {	
				if(dp[i] + dp[i-1] > 0)
				dp[i] += dp[i-1];
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		
		System.out.println(max);

	}

}
