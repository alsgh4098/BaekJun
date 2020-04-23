import java.util.Scanner;

public class Main_2156_포도주시식_silver1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[0] = arr[0];
		
		int max = 0;
		
		if(N>1) {			
			dp[1] = arr[1]+arr[0];
		}
		if(N>2) {
			dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
			dp[2] = Math.max(dp[2],dp[1]);
		}
		
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max( dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
			dp[i] = Math.max(dp[i],dp[i-1]);
			if(dp[i] > max) {
				max = dp[i];
			}
		}

		System.out.println(dp[N-1]);

	}

}
