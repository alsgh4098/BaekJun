import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기_silver1 {
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	
	static int N;
	static int Plus;
	static int Minus;
	static int Multi;
	static int Divide;
	static int[] number;
	static int[] op;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		number = new int[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = sc.nextInt();
		}
		
		Plus = sc.nextInt();
		
		Minus = sc.nextInt();
		
		Multi = sc.nextInt();
		
		Divide = sc.nextInt();

		op = new int[] {Plus,Minus,Multi,Divide};
		
		solution(1,number[0]);
		
		System.out.printf("%d\n%d\n",max,min);

	}
	
	static void solution(int index,int val) {
		if(index == N) {
			if(val < min) {
//				System.out.println();
				min = val;
			}
			if(val > max) {
				max = val;
			}
			return;
		}
		
		if(op[0] > 0) {
			op[0]--;
//			System.out.println(val);
			solution(index+1,val+ number[index]);
			op[0]++;
		}
		if(op[1] > 0) {
			op[1]--;
			solution(index+1,val- number[index]);
			op[1]++;
		}
		if(op[2] > 0) {
			op[2]--;
//			System.out.println(val);
			solution(index+1,val* number[index]);
			op[2]++;
		}
		if(op[3] > 0) {
			op[3]--;
			solution(index+1,val/ number[index]);
			op[3]++;
		}
		
		
		
	}
	
	

}
