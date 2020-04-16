import java.util.Arrays;
import java.util.Scanner;

public class Main_11722_가장긴증가하는부분수열_sivler2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.fill(dp, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] < arr[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
		
	}

}
