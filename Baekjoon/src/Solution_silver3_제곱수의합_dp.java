import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_silver3_제곱수의합_dp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[100001];
		
		// 라그랑주 네제곱수
		// 모든 양의 정수는 정수 네개의 제곱으로 나타 낼 수 있다.
		// 따라서 최댓값은 4를 넘지 않는다.
		Arrays.fill(dp, 4);
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j*j <= i; j++) {
				dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}

}
