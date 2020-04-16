import java.util.Arrays;
import java.util.Scanner;

public class Main_11404_플로이드워셜_gold4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] dp = new int[N][N];

		int V = sc.nextInt();

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < V; i++) {
			int ths = sc.nextInt() - 1;
			int tht = sc.nextInt() - 1;
			int weight = sc.nextInt();
//			System.out.println(weight);

			dp[ths][tht] = Math.min(dp[ths][tht], weight);
//			System.out.println(dp[ths][tht]);
		}

		// 플로이드 워셜
		for (int k = 0; k < dp.length; k++) {
			for (int i = 0; i < dp.length; i++) {
				if (k == i) {
					continue;
				}
				for (int j = 0; j < dp.length; j++) {
					if (j == i || j == k) {
						continue;
					}
					
					if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE) {						
						if (dp[i][j] > dp[i][k] + dp[k][j]) {
							dp[i][j] = dp[i][k] + dp[k][j];
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j] == Integer.MAX_VALUE ? 0 + " ": dp[i][j] + " ");
			}
			System.out.println();
		}

	}

}
