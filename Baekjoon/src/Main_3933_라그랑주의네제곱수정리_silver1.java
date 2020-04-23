import java.util.Scanner;

public class Main_3933_라그랑주의네제곱수정리_silver1 {
	
	static int number;
	static int sqrt;
	static int[] select;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			number = sc.nextInt();
			
			if(number == 0) {
				break;
			}
			
			sqrt = (int) Math.sqrt(number);
			
			select = new int[4];
			
			count = 0;
			
//			dfs(0,0);
			
			for (int i = 1; i <= sqrt; i++) {
				if(i*i == number) {
					count++;
					break;
				}
				for (int j = i; j <= sqrt; j++) {
					if(i*i+j*j == number) {
						count++;
						break;
					}
					for (int j2 = j; j2 <= sqrt; j2++) {
						if(i*i+j*j+j2*j2 == number) {
							count++;
							break;
						}
						for (int k = j2; k <= sqrt; k++) {
							if(i*i+j*j+j2*j2+k*k == number) {
								count++;
								break;
							}
							
						}
					}
				}
			}
			
			System.out.println(count);
		}

	}
	
//	static void dfs(int start, int cnt) {
//		if(cnt == 4) {
//			int sum = 0;
//			for (int i = 0; i < 4; i++) {
//				sum += select[i]*select[i];
//			}
//			if(sum == number) {
//				count++;
//				System.out.println();
//				for (int i = 0; i < select.length; i++) {
//					System.out.println(select[i]);
//				}
//				System.out.println();
//			}
//			
//			
//			return;
//		}
//		
//		for (int i = start; i <= sqrt; i++) {
//			select[cnt] = i;
//			dfs(start+1,cnt+1);
//		}
//		
//		
//	}

}
