import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_월드컵경기_silver3{
	
	static int[] thsTeam = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static int[] thtTeam = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	static int win;
	static int lose;
	static int draw;
	
	static int[] wins;
	static int[] loses;
	static int[] draws;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 팀의 승리수
		win = 0;
		// 팀의 패배수
		lose = 0;
		draw = 0;
		wins = new int[6];
		loses = new int[6];
		draws = new int[6];
		
		for (int i = 0; i < 4; i++) {
			String[] line = br.readLine().split(" ");
			// 0 1 2 / 3 4 5
			for (int j = 0; j <= 15; j+=3) {
				wins[j/3] = Integer.parseInt(line[j]);
				draws[j/3] = Integer.parseInt(line[j+1]);
				loses[j/3] = Integer.parseInt(line[j+2]);
				
				win += wins[j/3];
				draw += draws[j/3];
				lose += loses[j/3];
			}
			
			if(win+lose+draw != 30) {
//				System.out.println(win+lose+draw);
				sb.append(0+" ");
			}else {
//				System.out.println("!3123123123");
				if(dfs(0)) {
//					System.out.println("asds");
					sb.append(1+" ");
				}else {
					sb.append(0+" ");
				}
			}
			win = 0; lose = 0; draw = 0;
		}// end for
		
		System.out.println(sb);
	}// end main
	
	private static boolean dfs(int cnt) {
		
		
		if(cnt==15) {
//			System.out.println("asdas");
			for (int i = 0; i < 6; i++) {
				if( wins[i] != 0 || wins[i] != 0 ||
					loses[i] != 0 || loses[i] != 0 ||
					draws[i] != 0 || draws[i] != 0 ) {
					return false;
				}
			}
			return true;
		}
		
		int team1 = thsTeam[cnt];
		int team2 = thtTeam[cnt];
		
		
		// team1이 이겼을 경우.
		if(wins[team1]>=1 && loses[team2] >= 1) {
			wins[team1]--;
			loses[team2]--;
			if(dfs(cnt+1)) {
				return true;
			};
			wins[team1]++;
			loses[team2]++;
		}
		
		// 무승부일 경우
		if(draws[team1]>=1 && draws[team2] >= 1) {
			draws[team1]--;
			draws[team2]--;
			if(dfs(cnt+1)) {
				return true;
			};
			draws[team1]++;
			draws[team2]++;
		}
		
		// team2이 이겼을 경우.
		if(wins[team2]>=1 && loses[team1] >= 1) {
			wins[team2]--;
			loses[team1]--;
			if(dfs(cnt+1)) {
				return true;
			};
			wins[team2]++;
			loses[team1]++;
		}
		
		return false;
	}
}


//5 0 0 
//3 0 2 
//2 0 3 
//0 0 5 
//4 0 1 
//1 0 4

//4 1 0 
//3 0 2 
//4 1 0 
//1 1 3 
//0 0 5 
//1 1 3


//5 0 0 
//4 0 1 
//2 2 1 
//2 0 3 
//1 0 4 
//0 0 5
