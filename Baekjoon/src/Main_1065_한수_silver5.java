//import java.util.Arrays;
import java.util.Scanner;

public class Main_1065_한수_silver5 {
	
	static boolean[]arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		arr = new boolean[N+1];
		
//		Arrays.fill(arr, true);
		
		String number = "";
		int interval = 0;
		int count = N;
		
		for (int i = 100; i < N+1; i++) {
			number = Integer.toString(i);
			interval = number.charAt(0)-number.charAt(1);
			for (int j = 1; j < number.length()-1; j++) {
				if(number.charAt(j)-number.charAt(j+1) == interval) {
					
				}else {
					count--;
//					arr[i] = false;
					break;
				}
			}
		}
		
		System.out.println(count);

	}

}
