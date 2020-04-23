import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2231_분해합_Bronze2 {
	
	// 브루탈 알고리즘
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String number = br.readLine();
		int num = Integer.parseInt(number);
		
		int min = Integer.MAX_VALUE;
		
		
		int num_copy = num;
		int sum;
		String num_str;
		char[] chr_arr;
		
		while(num_copy>0) {
			
			num_copy -= 1;
			num_str = Integer.toString(num_copy);
			chr_arr = num_str.toCharArray();
			
			sum = num_copy;
			for (int i = 0; i < chr_arr.length; i++) {
				sum += chr_arr[i]-'0';
//				System.out.println(chr_arr[i]-'0');
			}
//			System.out.println(sum);
			if(sum == num) {
				if(num_copy < min) {
					min = num_copy;
//					System.out.println(min);
				}
			}
//			System.out.println("Asdasd");
		}
		
		if(min == Integer.MAX_VALUE) {
			min = 0;
		}
		
		
		System.out.println(min);
		
		

	}

}
