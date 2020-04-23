import java.util.Scanner;

public class Main_1094_막대기_silver5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		int arr[] = {64,32,16,8,4,2,1};
		
		int my_stick = 0;
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(my_stick + arr[i] <= number) {
				my_stick += arr[i];
				count++;
			}
			
			if(my_stick == number) {
				break;
			}
		}
		
		System.out.println(count);

	}

}
