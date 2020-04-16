import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1798_블랙잭 {
	
	static int[] card;
	static int[] take_3_card = new int[3]; 
	static int N;
	static int M;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		if( N < 3 && 100 < N ) {
			return;
		}
		
		M = Integer.parseInt(st.nextToken());
		
		if( M < 10 && 300000 < M ) {
			return;
		}
		
		card = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			if(card[i] < 0) {
				return;
			}
		}
		
		combi(0,0);
		
		System.out.println(max);
		
	}
	
	public static void combi(int start, int count) {
		if(3 == count) {
			int sum = 0;
			for (int i = 0; i < take_3_card.length; i++) {
				sum += take_3_card[i];
			}
			// sum은 끝나고 비교하자
			if( sum <= M && max <= sum) {
				max = sum;
			}
		}else {
			for (int i = start; i < N; i++) {
				take_3_card[count] = card[i];
				combi(i+1,count+1);
			}
		}
	}
}
