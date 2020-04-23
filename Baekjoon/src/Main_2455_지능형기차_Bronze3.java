import java.util.Arrays;
import java.util.Scanner;

public class Main_2455_지능형기차_Bronze3 {
	
	static int[] getOn = new int[4];
	static int[] getOff = new int[4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			getOff[i] = sc.nextInt();
			getOn[i] = sc.nextInt();
		}
		
		int[] people = new int[3];
		
		int sum = 0;
		
		for (int i = 0; i < 3; i++) {
			sum += getOn[i] - getOff[i]; 
			people[i] = sum;
		}
		
		Arrays.sort(people);
		
		System.out.println(people[2]);

	}

}
