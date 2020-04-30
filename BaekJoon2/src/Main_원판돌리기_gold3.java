import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_원판돌리기_gold3 {

	static int[][] rnds;
	static int[][] moves;

	static int N;
	static int M;
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		T = Integer.parseInt(line[2]);

		rnds = new int[N][M];
		for (int i = 0; i < N; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				rnds[i][j] = Integer.parseInt(line[j]);
			}
		}

		// x의 배수인 원판들
		// d방향 0이 오른쪽 1은 왼쪽
		// k칸
		moves = new int[T][3];

		for (int i = 0; i < T; i++) {
			line = br.readLine().split(" ");
			moves[i][0] = Integer.parseInt(line[0]);
			moves[i][1] = Integer.parseInt(line[1]);
			moves[i][2] = Integer.parseInt(line[2]);
//			System.out.println(moves[i][0]);
//			System.out.println(moves[i][1]);
//			System.out.println(moves[i][2]);
		} // end input

		for (int i = 0; i < T; i++) {
			int x = moves[i][0];
			int d = moves[i][1];
			int k = moves[i][2];
			move(x, d, k);
		}

		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res += rnds[i][j];
			}
		}

		System.out.println(res);
	}// end main

	private static void move(int x, int d, int k) {

		for (int i = 1; i * x <= N; i++) {
			movethis((i * x) - 1, d, k);
		}
		calc();
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(rnds[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	private static void movethis(int t, int d, int k) {
		if (d == 0) {
			for (int i = 0; i < k; i++) {
				int temp = rnds[t][M - 1];
				for (int j = M - 1; j > 0; j--) {
					rnds[t][j] = rnds[t][j - 1];
				}
				rnds[t][0] = temp;
			}
		} else if (d == 1) {
			for (int i = 0; i < k; i++) {
				int temp = rnds[t][0];
				for (int j = 0; j < M - 1; j++) {
					rnds[t][j] = rnds[t][j + 1];
				}
				rnds[t][M - 1] = temp;

			}
		} // end logic

	}

	private static void calc() {
		
		// 인접수가 없을경우.
		if (!close()) {
			
			double sum = 0;
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int K = 0; K < M; K++) {
					sum += rnds[i][K];
					if (rnds[i][K] != 0) {
						cnt++;
					}
				} // end for
			}
			
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < M; k++) {
					if (rnds[i][k] > sum / cnt) {
						rnds[i][k] -= 1;
					} else if(rnds[i][k] < sum / cnt && rnds[i][k] != 0){
						rnds[i][k] += 1;
					}
				}
			}
		} // end check

	}// end logic

	// 인접
	private static boolean close() {

		boolean check = false;
		int[][] nrnds = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				nrnds[i][j] = rnds[i][j];
			}
		}

		// 한 원판 내에서
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M - 1; j++) {
				if (rnds[i][j] == rnds[i][j + 1] && rnds[i][j] != 0 && rnds[i][j + 1] != 0) {
					nrnds[i][j] = 0;
					nrnds[i][j + 1] = 0;
					check = true;
				}
			}
			if (rnds[i][0] == rnds[i][M - 1] && rnds[i][0] != 0 && rnds[i][M-1] != 0) {
				nrnds[i][0] = 0;
				nrnds[i][M - 1] = 0;
				check = true;
			}
		}

		// 서로인접한 원판들.
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N - 1; i++) {
				if (rnds[i][j] == rnds[i + 1][j] ) {
					nrnds[i][j] = 0;
					nrnds[i + 1][j] = 0;
					if(rnds[i][j] != 0 && rnds[i+1][j] != 0) {						
						check = true;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rnds[i][j] = nrnds[i][j];
			}
		}

		return check;
	}

}
