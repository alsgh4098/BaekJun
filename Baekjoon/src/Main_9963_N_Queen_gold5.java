import java.util.Scanner;

public class Main_9963_N_Queen_gold5 {
	
	static int N;
	static int cnt;
	static int[] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		cnt = 0;
		
		// 행이나 열을 기준으로 우선 퀸 하나를 놓는다.
		for (int i = 0; i < N; i++) {		
			// 첫행을 만들어 놓고,
			map = new int[N];
			map[0] = i;
			nqueen(0);
		}
		
		
		System.out.println(cnt);

	}

	private static void nqueen(int row) {
		if(row == N-1) {
			cnt++;
			return;
		}else {
			for (int i = 0; i < N; i++) {
				// 이전 row+1을 해준다. i는 행
				map[row+1] = i;
				if(possible(row+1)) {
					// 가능하다면 다음 행으로 넘어간다.
					nqueen(row+1);
				}else {
					map[row+1] = 0;
				}
			}
		}
		map[row] = 0;
	}

	private static boolean possible(int row) {
		
		for (int i = 0; i <= row-1; i++) {
			
			// 열이 같다면.
			if(map[i] == map[row]) {
				return false;
			}
			
			// 4방의 대각선에 위치한다면.
			if(Math.abs(map[i] - map[row]) == Math.abs(i-row)) {
				return false;
			}
		}
		
		return true;
	}

}
