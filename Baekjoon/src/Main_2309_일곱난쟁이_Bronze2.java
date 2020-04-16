import java.util.Arrays;
import java.util.Scanner;

//하나의 경우의수를 찾으면 종료.
//경우의 수 아직 익숙치 않음.


public class Main_2309_일곱난쟁이_Bronze2 {
	
	static int[] arr = new int[9];
	static int[] seven = new int[7];
	static boolean finish;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		bf(0,0);

	}
	
	static void bf(int start, int count) {
		if(count == 7) {
			int sum = 0;
			for (int i = 0; i < seven.length; i++) {
				sum += arr[seven[i]];
			}
			if(sum == 100) {
				for (int i = 0; i < seven.length; i++) {
					System.out.println(arr[seven[i]]);
				}
				finish = true;
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			seven[count] = i;
			bf(i+1,count+1);
			if(finish) break;
		}
	}
}