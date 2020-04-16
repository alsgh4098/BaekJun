import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기_silver5 {

	static char[][] map;
	static char[][] b_map;
	static char[][] w_map;
	static int res = 0;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		b_map = new char[N][M];
		w_map = new char[N][M];
		String str = null;
		char[] chr_arr;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			chr_arr = str.toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = chr_arr[j];
			}
		}
		
		// B로 시작하는 맵
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				b_map[i][j] = (i+j)%2 == 0 ? 'B':'W';
			}
		}
		
		// W로 시작하는 맵
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				w_map[i][j] = (i+j)%2 == 0 ? 'W':'B';
			}
		}
		
		
		int w_count = 0;
		int b_count = 0;
		
		int min = Integer.MAX_VALUE;
		
		
		for (int k = 0; k <= N-8; k++) {
			for (int n = 0; n <= M-8; n++) {
				w_count = 0;
				b_count = 0;
				for (int i = 0+k; i < 8+k; i++) {
					for (int j = 0+n; j < 8+n; j++) {
						if( w_map[i][j] != map[i][j]) {
							w_count++;
						}
						if( b_map[i][j] != map[i][j]) {
							b_count++;
						}
					}
				}
				
				if(min > w_count) {
					min = w_count;
				}
				if(min > b_count) {
					min = b_count;
				}
			}
		}
		
//		int res = w_count > b_count ? b_count:w_count;
		
		
		System.out.println(min);
	}


	
	static void printMap(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
