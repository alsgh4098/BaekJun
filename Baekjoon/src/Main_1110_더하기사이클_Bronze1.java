import java.util.Scanner;

public class Main_1110_더하기사이클_Bronze1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String num_copy = sc.next();
		
		if(num_copy.length() < 2) {
			num_copy = "0"+num_copy;
		}
		
		int count = 0;
		String next_num = new String(num_copy);
		
		do {
			
			char first = next_num.charAt(1);
			int second = (next_num.charAt(0) - '0') + (next_num.charAt(1) - '0');
			if(second >= 10) {
				second %= 10;
			}
		
			next_num = new String(first+Integer.toString(second));
//			System.out.println(new String(first+Integer.toString(second)));
//			System.out.println(next_num);
			count++;
			
		}while( !next_num.equals(num_copy));
		
		System.out.println(count);

	}

}
