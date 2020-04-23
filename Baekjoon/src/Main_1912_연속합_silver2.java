import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// DP


public class Main_1912_연속합_silver2 {

	static int N;
	static int max = Integer.MIN_VALUE;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}

		for (int i = 1; i < N; i++) {

			if (numbers[i - 1] > 0 && numbers[i] + numbers[i - 1] > 0) {
				numbers[i] += numbers[i - 1];
			}

			if (max < numbers[i]) {
				max = numbers[i];
			}
		}
		
		if (max < numbers[0]) {
			max = numbers[0];
		}
		
		System.out.println(max);

	}

}
