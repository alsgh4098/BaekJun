import java.util.Scanner;

public class Main_1003_피보나치_silver3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			int number = sc.nextInt();
			
			int[] zero_dp = new int[number+1];
			int[] one_dp = new int[number+1];
			
			zero_dp[0] = 1;			
			one_dp[0] = 0;
			
			if(number >= 1) {				
				zero_dp[1] = 0;
				one_dp[1] = 1;
			}
			
			if(number >= 2) {
				for (int i = 2; i < number+1; i++) {
					zero_dp[i] = zero_dp[i-1]+zero_dp[i-2];
				}
				
				for (int i = 2; i < number+1; i++) {
					one_dp[i] = one_dp[i-1]+one_dp[i-2];
				}
			}
			
			System.out.println(zero_dp[number] +" "+ one_dp[number]);
		}
	}


}
