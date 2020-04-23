import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 간단하게 생각해라.


public class Main_2740_행렬곱셈_Bronze1 {
	
	static int[][] mat1;
	static int[][] mat2;
	static int[][] res;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		mat1 = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mat1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	
		mat2 = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				mat2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		res = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int l = 0; l < M; l++) {
					res[i][j] += mat1[i][l] * mat2[l][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
