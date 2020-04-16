import java.util.Scanner;

public class Main_2839_설탕배달_Bronze1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 설탕 무게
		int N = sc.nextInt();
		
		// 봉지 수
		int res = 0;
		
		int bag_5 = N/5;
		N %= 5;
		int bag_3 = 0;
		
		while(bag_5 >= 0) {
			if(N%3 == 0) {
				bag_3 = N/3;
				N %= 3;
				break;
			}else {
				bag_5--;
				N += 5;
			}
		}
		
		res = (N ==0 ) ? bag_3+bag_5:-1;
		
		
		System.out.println(res);
		

	}

}
