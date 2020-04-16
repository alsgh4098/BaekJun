import java.util.Scanner;

public class Main_10448_유레카이론 {
	
	static int N;
	
	static int[] tri_num = new int[50];
	
	// 1,2,3
	static int[] select = new int[3];
	
	static int[] arr;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 삼각수 만들어 놓기.
		for (int i = 1; i < tri_num.length; i++) {
			tri_num[i] = (i*(i+1))/2;
		}
		
//		for (int i = 1; i < tri_num.length; i++) {
//			System.out.println(tri_num[i]);
//		}
		
		for (int i = 0; i < arr.length; i++) {
			int number = arr[i];
//			System.out.println(number);
			System.out.println(bf(number,0));
		}
		
		

	}
	
	static int bf(int number,int count) {
		if(count == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += tri_num[select[i]];
			}
//			System.out.println(sum);
			if(sum == number) {
//				System.out.println(number);
				return 1;
			}else{
				return 0;
			}
		}
		
		for (int i = 1; i < tri_num.length; i++) {
			select[count] = i;
			if(bf(number,count+1) == 1) {
				return 1;
			}
		}
		
		return 0;
	}


}
