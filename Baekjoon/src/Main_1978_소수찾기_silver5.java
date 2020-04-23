import java.util.Arrays;
import java.util.Scanner;

// 에라토스테네스의 체


public class Main_1978_소수찾기_silver5 {
	
	static boolean[] arr = new boolean[1001];
	
	public static void main(String[] args) {
		
		Arrays.fill(arr, true);
		
		arr[0] = false;
		arr[1] = false;

		for (int i = 2; i < arr.length; i++) {
			for (int j = 2; i*j<=1000; j++) {
				int index = i*j;
				arr[index] = false;
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] num = new int[N];
		
		int count = 0;
		
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			if(arr[num[i]]) {
				count++;
			}
		}
		
		System.out.println(count);
		
//		System.out.println(arr[99]);
		
	}

}
