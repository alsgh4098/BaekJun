import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사_silver5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Counsel[] list = new Counsel[N];
		
		int[] dp = new int[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int sal = Integer.parseInt(st.nextToken());
			list[i] = new Counsel(day,sal);
			//~일까지의 최대이익을 담을 dp어레이
			dp[i] = sal;
		}
		
		for (int i = 1; i < list.length; i++) {
			for (int j = 0; j < i; j++) {
				//날짜 조건.
				if( i - j >= list[j].day) {
					dp[i] = Math.max(dp[i], list[i].sal + dp[j]);
				}
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < list.length; i++) {
			if(max < dp[i]
			   && i+list[i].day <= N) {
				max = dp[i];
			}
//			System.out.println(dp[i]);
		}
		
		System.out.println(max);

	}
	
	static class Counsel{
		int day;
		int sal;
		
		public Counsel(int day, int sal) {
			super();
			this.day = day;
			this.sal = sal;
		}
		
		
	}

}
