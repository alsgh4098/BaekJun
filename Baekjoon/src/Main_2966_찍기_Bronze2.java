import java.util.Scanner;

public class Main_2966_찍기_Bronze2 {
	
	static int N;
	
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		String answer = sc.next();
		
		String str = "ABC";
		String str2 = "";
		int i = 0;
		while(!(str2.length() == N)) {
			str2 += str.charAt(i);
			i++;
			if(i > 2) {
				i = 0;
			}
		}
		String Adrian = str2.toString();
		
		str = "BABC";
		str2 = "";
		i = 0;
		while(!(str2.length() == N)) {
			str2 += str.charAt(i);
			i++;
			if(i > 3) {
				i = 0;
			}
		}
		String Bruno = str2.toString();
		
		str = "CCAABB";
		str2 = "";
		i = 0;
		while(!(str2.length() == N)) {
			str2 += str.charAt(i);
			i++;
			if(i > 5) {
				i = 0;
			}
		}
		String Goran = str2.toString();
		
		int A_cnt = 0;
		int B_cnt = 0;
		int G_cnt = 0;
		
		for (int j = 0; j < N; j++) {
			if(answer.charAt(j) == Adrian.charAt(j)) {
				A_cnt++;
			}
			
			if(answer.charAt(j) == Bruno.charAt(j)) {
				B_cnt++;
			}
			
			if(answer.charAt(j) == Goran.charAt(j)) {
				G_cnt++;
			}

		}
		
		if(max < A_cnt) {
			max = A_cnt;
		}
		if(max < B_cnt) {
			max = B_cnt;
		}
		if(max < G_cnt) {
			max = G_cnt;
		}
		
		System.out.println(max);
		if(A_cnt == max) {
			System.out.println("Adrian");
		}
		if(B_cnt == max) {
			System.out.println("Bruno");
		}
		if(G_cnt == max) {
			System.out.println("Goran");
		}

		
	}

}
