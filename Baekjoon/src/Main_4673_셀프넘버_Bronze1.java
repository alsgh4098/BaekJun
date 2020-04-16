import java.util.Arrays;

public class Main_4673_셀프넘버_Bronze1 {
	
	static boolean[] self = new boolean[10001];

	public static void main(String[] args) {
		
		String number = "";
		
		int int_num = 0;
		
		Arrays.fill(self, true);
		
		for (int i = 1; i < 10001; i++) {
			number = Integer.toString(i);
			int_num = i;
			for (int j = 0; j < number.length(); j++) {
				int_num += number.charAt(j)-'0';
			}
			
			if(int_num <= 10000) {
				self[int_num] = false;
			}
			
		}
		
		for (int i = 1; i < 10001; i++) {
			if(self[i]) {
				System.out.println(i);
			}
		}
		
	}

}
