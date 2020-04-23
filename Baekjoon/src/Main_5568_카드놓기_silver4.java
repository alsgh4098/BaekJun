//import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// set을 사용하는게 핵심.

// permu도.

public class Main_5568_카드놓기_silver4 {
	
	static Set<String> set = new HashSet<String>();
	
	static int[] card;
	static int[] select;
	
	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		card = new int[N];
		select = new int[R];
		
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		permu(0,0);
		
		System.out.println(set.size());
	}
	
	static void permu(int flag, int count) {
		if(count == R) {
			String number = "";
			for (int i = 0; i < R; i++) {
				number += card[select[i]];
			}
			set.add(number);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if( (flag&1 << i) != 0) {
				continue;
			}else {
				select[count] = i;				
				permu(flag|1 << i,count+1);
			}
				
		}
	}

}
