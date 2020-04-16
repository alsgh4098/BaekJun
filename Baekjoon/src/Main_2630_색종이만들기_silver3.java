import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기_silver3 {
	
	static int N;
	static int[][] map;
	static int one_cnt;
	static int zero_cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solution(0,0,N);
		
		System.out.printf("%d\n%d",zero_cnt,one_cnt);
	}
	
	static void solution(int x, int y, int N) {
		boolean check = true;
		int value = map[x][y];
		
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if(map[i][j] != value) {
					check = false;
					break;
				}
			}
		}
		
		if(!check) {
			solution(x, y, N/2);
			solution(x+N/2, y, N/2);
			solution(x, y+N/2, N/2);
			solution(x+N/2, y+N/2, N/2);
		}else {
			
			if(value == 1) {
				one_cnt++;
			}else {
				zero_cnt++;
			}
			return;
		}
	}
	
	static void printMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
